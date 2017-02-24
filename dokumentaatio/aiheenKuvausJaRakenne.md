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
Sisältää virheiden käsittelyä jokaiselle komennolle, josta saattaa poikiintua ohjelmalle oma loggeri<br><br><br>


---VKO 6 Deadlinea varten uusi kuvaus---<br><br>

MacroScript on tapahtumien automatisointiin luotu ohjelma. Sen avulla voi luoda skriptejä, joita ohjelma sitten suorittaa.
Ohjelman voi laittaa tekemään toisteista työtä, esimerkiksi joidenkin taulukoiden täyttämistä. Ohjelmaa voi tietysti
käyttää myös pelien pelaamiseen. Liikkeelle ohjelma lähtee tiedostosta MacroScipt.java.<br><br>

Toiminnallisuuksien kirjoon kuuluu esimerkiksi hiiren liikuttaminen sekä vasemman että oikean napin painallukset näitä
toiminnallisuuksia hoitaa MouseOperator.java luokka.<br><br>

Näppäimistön toiminta on pääosin saatavilla ja tähän kuuluu enganninkielen aakkoset (a-z), isot ja pienet kirjaimet,
numerot, sekä suomalaisen näppäimistön mukaiset erikoismerkit (shift+numero) myös ",.-" ovat käytettävissä kuten ovat
enter ja välilyöntikin. Näitä puolestaan toteutetaan KeyboardOperator.java luokassa.<br><br>

Ohjelmaan on rakennettu toiminnallisuus, joka osaa eri tavoin etsiä värejä näytöltä. Tätä ominaisuutta voi käyttää
esimerkiksi tekstin tunnistamiseen ja peleissä vihollisten ym. tunnistamiseen. Värien etsiminen oli tehokkainta
toteuttaa niin, että piste, josta väri löytyy voidaan asettaa parametriksi jollekin komennolle (myös koko
värin löytyminen voidaan ehdollistaa, eli suoritetaan joku komento, jos väri löytyy jostain.
Värien etsinnän hoitaa luokka ColorOperator.java.<br><br>

Värinetsinnän käsitteleminen skriptissä sai suhteellisen laajuutensa vuoksi oman luokan FindColorOperator.java.<br><br>

Ohjelman ollessa skriptattava, muodostui pakollinen tarve saada skripteihin ehdollistaminen mahdolliseksi, eli toisin
sanoen if-lauseille oli pakko kehittää toiminnallisuus. Tämä sai oman luokan, IfHandler.java<br><br>

Tuntui myös oleelliselta, että ohjelman voisi saada tekemään loopia, joten goto komennolle muodostui tarve.<br><br>
Jotta looppeja voitaisiin hallita jotenkin, muodostui tarve int muuttujille
ja näistä muodostui oma luokka, jossa käsitellään siis if-lauseita ja skriptin sisäisiä int-muuttujia. Muuttujille on
käytettävissä laskutoimituksia, jotka ovat summa-, erotus-, jako- ja kertolaskut. Taas syntyy uusi luokka, VariableOperator.java.<br><br>

Käyttöliittymä sisältää kaksi luokkaa. Itse pääikkunan, jossa näytetään hiiren koordinaatit
(yhden näytös sisältävissä järjestelmissä) 10ms päivitysvälein. Ikkuna sisältää teksti kentän skriptiä varten, ikonin,
joka aktivoi värinpoimimisominaisuuden, labelin, johon väri asetellaan tarkastelua varten ja tekstikentän jossa väri
ilmoitetaan hex-muodossa. Nämä toiminnallisuudet on havaittaivissa luokassa frmMain.Java.<br><br>

Toinen käyttöliittymällinen luokka on loki-ikkuna. Siihen tulee ystävälliset ilmoitukset käyttäjälle jos hän on
kirjoittanut virheellistä skriptiä tai skriptissä on automaattisesti oikaistuja epäkohtia.<br><br><br>



![Alt text](luokkakaavio.png "Luokkakaavio")
