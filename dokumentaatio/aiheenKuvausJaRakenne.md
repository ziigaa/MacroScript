Dokumentaatio

Toteutetaan käyttöliittymällinen, käyttäjän ohjelmoitavissa oleva macro-ohjelma, joka suorittaa tekstikenttään syötettyjä
komentoja, kuten kursorin position vaihtaminen, hiiren klikkailu, tekstin kirjoitus, ym.

Toiminnallisuus:
-Luo uusi skripti (ensin herjaa, että haluatko tallentaa)
-Tallenna skripti (Buffered)
-Avaa skripti (Buffered)
-Suorita skripti
-(Jonkinasteinen skriptin syntaksin tarkistus ennen varsinaista ajoa)

-Hiiren position seuraaminen timerin avulla (yhden näytön sisältävissä järjestelmissä)
-Värin tunnistaminen kursorin alta kun toiminto on aktivoitu, lopetus kun jFrame menettää fokuksensa
-Värin esittäminen jLabelissa
-Värin esittäminen hex-muodossa tekstikentässä (mahdollisesti skriptissä toteutettavia värin etsimiskomentoja varten)
-Skriptin rivinumeroiden ilmaiseminen (joko pelkästään rivi, jolla ollaan tai mahdollisesti (toivottavasti) sarake, josta näkyy kaikki näytöllä näkyvien rivien numerot)

Komennot:
(nimet tms. lienevät jossakin määrin eksplisiittisiä):

if (toimivuus rajoittuu if muuttuja=toinen_muuttuja komento tai if muuttuja=int_arvo komento esim. if i=3 setMousePos 1 1 tai if i=j setMousePos 1 1)
goto (ainoastaan esim. @-merkillä spesifioituihin kohtiin)
sleep (odotustoiminto millisekunneissa)
colorPalette (kirjoitusasultaan muunneltu arraylist muuttuja)
int (muuttuja)
int muuttujien peruslaskutoimitukset, eli +, -, *, /.

mouseLeftDown (hiiren vasen nappi alas)
mouseLeftUp (hiiren vasen nappi ylös)
mouseRightDown (hiiren oikea nappi alas)
mouseRighUp (hiiren oikea nappi ylös)
setMousePos (aseta kursorin sijainti)
moveMouseSmooth (liikuttaa hiirtä taloudellisinta laskettua rataa pitkin kohdepisteeseen, voi sisältää nopeuteen vaikuttavan tekijän)
moveMouseHuman (liikuttaa hiirtä "ihmismäisesti", eli epäsuoraa reittiä, määritettyihin koordinaatteihin ja yleensä ei osu täsmälleen syötettyihin koordinaatteihin)
mouseLeftClick (hiiren vasen nappi alas ja ylös tehokkaimmalla tavalla)
mouseRightClick (hiiren oikea nappi alas ja ylös tehokkaimmalla tavalla)
mouseHumanLeftClick (ero tavalliseen on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja ja painallusta edeltävä pieni pysähdys)
mouseHumanRightClick (ero tavalliseen on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja ja painallusta edeltävä pieni pysähdys)

keyDown (näppäin alas)
keyUp (näppäin ylös)
type (kirjoittaa nopeimmalla tavalla syötteessä annetun tekstin)
typeHuman (kirjoittaa syötteessä annetun tekstin tavalla, jossa kunkin painalluksen pohjassaoloaikaan vaikuttaa satunnainen viiveluku. Sama vaikuttaa intervalliin napin painalluksien välillä)

findColor (etsii näytöltä pisteen, joka on annetun syötteen värinen ja palauttaa sen koordinaatit)

esim. @-merkin rivin alussa sisältävät kohdat goto-komentoa varten

Skriptin suoritusmoottori (käy skriptin rivi riviltä läpi ja suorittaa validit komennot)
Syntaksi-info
Virheiden käsittelyä jokaiselle komennolle

Jos näissä ei ole tarpeeksi tekemistä tms., niin toiminnallisuuksiin saattaisi voida lisätä mahdollisuuden
nauhoittaa skriptejä (tosin ainoastaan hiiren liikkeet ja mahdollisesti kirjoittaminen ovat ainoat mitä tähän tulisi)
Lisäksi jos tosiaan aikaa on liikaa, niin voisin yrittää perehtyä suoritettavan rivin "highlightaamiseen".

![Alt text](luokkakaavio.png "Luokkakaavio")
