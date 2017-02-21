Dokumentaatio<br><br>

Toteutetaan käyttöliittymällinen, käyttäjän ohjelmoitavissa oleva macro-ohjelma, joka suorittaa tekstikenttään syötettyjä
komentoja, kuten kursorin position vaihtaminen, hiiren klikkailu, tekstin kirjoitus, ym.<br><br>

Käyttöliittymän toiminnallisuus:<br>
-Luo uusi skripti (ensin herjaa, että haluatko tallentaa)<br>
-Tallenna skripti (Buffered)<br>
-Avaa skripti (Buffered)<br>
-Suorita skripti<br>
-Virheilmoitusikkuna<br><br>

-Hiiren position seuraaminen timerin avulla (yhden näytön sisältävissä järjestelmissä)<br>
-Värin tunnistaminen kursorin alta kun toiminto on aktivoitu, lopetus kun jFrame menettää fokuksensa<br>
-Värin esittäminen jLabelissa<br>
-Värin esittäminen hex-muodossa tekstikentässä (skriptissä käytettyjen värinetsimiskomentojen vuoksi)<br><br>

Itse skriptien toiminta:<br>
(nimet tms. lienevät jossakin määrin eksplisiittisiä):<br><br>

if<br>
-Käyttötapaukset (Huom! if-lauseen toiminta rajoittuu näihin!):<br>
--if muuttuja=toinen_muuttuja komento<br>
--tai<br>
--if muuttuja=int_arvo komento<br>
--esim. if i=3 setMousePos 1 1 tai if i=j setMousePos 1 1)<br>
--if värinetsintäfunktio komento<br>
--esim. if findColor #000000 0 0 40 40 setMousePos 1 1<br>
--tai<br>
--if findColorFromPaletteStartingFromPoint #000000 20 20 100 100 60 60 setMousePos findColorFromPaletteStartingFromPoint #000000 20 20 100 100 60 60<br><br>
goto (ainoastaan esim. @-merkillä spesifioituihin kohtiin)<br>
sleep (odotustoiminto millisekunneissa)<br>
colorPalette (kirjoitusasultaan muunneltu arraylist muuttuja johon syötetään värit hex-muodossa. esim. colorPalette #000000 #FFFFFF)<br>
int (muuttuja)<br>
-esim int i<br>
-tai int i=3<br>
int muuttujien peruslaskutoimitukset, eli +, -, *, /.<br><br>

Hiiren komentoja (MouseOperator):
mouseLeftDown (hiiren vasen nappi alas)<br>
mouseLeftUp (hiiren vasen nappi ylös)<br>
mouseRightDown (hiiren oikea nappi alas)<br>
mouseRighUp (hiiren oikea nappi ylös)<br>
setMousePos (aseta kursorin sijainti)<br>
moveMouseSmooth (liikuttaa hiirtä taloudellisinta laskettua rataa pitkin kohdepisteeseen, voi sisältää nopeuteen vaikuttavan tekijän)<br>
moveMouseHuman (liikuttaa hiirtä "ihmismäisesti", eli epäsuoraa reittiä, määritettyihin koordinaatteihin ja yleensä ei osu täsmälleen syötettyihin koordinaatteihin)<br>
mouseLeftClick (hiiren vasen nappi alas ja ylös tehokkaimmalla tavalla)<br>
mouseRightClick (hiiren oikea nappi alas ja ylös tehokkaimmalla tavalla)<br>
mouseHumanLeftClick (ero tavalliseen on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja ja painallusta edeltävä pieni pysähdys)<br>
mouseHumanRightClick (ero tavalliseen on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja ja painallusta edeltävä pieni pysähdys)<br><br>

Näppäimistön komentoja (KeyboardOperator):<br>
keyDown (näppäin alas)<br>
keyUp (näppäin ylös)<br>
pressEnter (painaa enter-näppäintä)
type (kirjoittaa nopeimmalla tavalla syötteessä annetun tekstin)<br>
typeHuman (kirjoittaa syötteessä annetun tekstin tavalla, jossa kunkin painalluksen pohjassaoloaikaan vaikuttaa satunnainen viiveluku. Sama vaikuttaa intervalliin napin painalluksien välillä)<br><br>

Parametreinä tai if-lauseen ehtoina (ColorOperator):<br>
findColor (etsii näytöltä pisteen, joka on annetun syötteen värinen syötetyn Rectangle-olion koordinaattien sisältä ja palauttaa sen koordinaatit)<br>
findColorFromPalette (etsii näytöltä pisteen, joka on colorPalette-muuttujan sisältämän syötteen värinen, syötetyn Rectangle-olion koordinaattien sisältä ja palauttaa sen koordinaatit)<br>
findColorStartingFromPoint (etsii näytöltä spiraalimaisesti syötteellä määritetyn värin sisältämän pisteen annetuista koordinaateista lähtien, syötetyn Rectangle-olion koordinaattien sisältä ja palauttaa sen koordinaatit)<br>
findColorFromPaletteStartingFromPoint (etsii näytöltä spiraalimaisesti colorPalette-muuttujassa määritetyn värin sisältämän pisteen annetuista koordinaateista lähtien, syötetyn Rectangle-olion koordinaattien sisältä ja palauttaa sen koordinaatit)<br><br>

Erikoistapaus:<br>
@-merkin rivin alussa sisältävät kohdat goto-komentoa varten<br>

Skriptin suoritusmoottori (käy skriptin rivi riviltä läpi ja suorittaa validit komennot, ohittaen virheelliset syötteet)<br>
Sisältää virheiden käsittelyä jokaiselle komennolle, josta saattaa poikiintua ohjelmalle oma loggeri<br>


![Alt text](luokkakaavio.png "Luokkakaavio")
