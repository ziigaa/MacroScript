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

Täydellistä listaa komennoista en voi vielä tarjota, mutta tässä vaiheessa seuraavat todennäköisesti kuuluvat
toteutettavien komentojen joukkoon (nimet tms. lienevät jossakin määrin eksplisiittisiä):

if (toimivuus rajallinen)
goto (ainoastaan esim. @-merkillä spesifioituihin kohtiin)
sleep (odotustoiminto millisekunneissa)
colorPalette (kirjoitusasultaan muunneltu arraylist muuttuja)
int (muuttuja)
int muuttujien peruslaskutoimitukset

mouseLeftDown (hiiren vasen nappi alas)
mouseLeftUp (hiiren vasen nappi ylös)
mouseRightDown (hiiren oikea nappi alas)
mouseRighUp (hiiren oikea nappi ylös)
setMousePos (aseta kursorin sijainti)
moveMouseSmooth (liikuttaa hiirtä taloudellisinta laskettua rataa pitkin kohdepisteeseen, voi sisältää nopeuteen vaikuttavan tekijän)
moveMouseHuman (liikuttaa hiirtä "ihmismäisesti", eli epäsuoraa reittiä, joskus menee ohi kohteesta ja yleensä ei osu täsmälleen määritettyihin koordinaatteihin)
mouseLeftClick (hiiren vasen nappi alas ja ylös tehokkaimmalla tavalla)
mouseRightClick (hiiren oikea nappi alas ja ylös tehokkaimmalla tavalla)
mouseHumanLeftClick (ero tavalliseen on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja)
mouseHumanRightClick (ero tavalliseen on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja)

keyDown (näppäin alas)
keyUp (näppäin ylös)
type (kirjoittaa nopeimmalla tavalla syötteessä annetun tekstin)
typeHuman (kirjoittaa syötteessä annetun tekstin tavalla, jossa kunkin painalluksen pohjassaoloaikaan vaikuttaa satunnainen viiveluku, saattaa mahdollisesti sisältää typoja ja niiden korjaamista)

findColorOnScreen (etsii näytöltä pisteen, joka on annetun syötteen värinen ja palauttaa sen koordinaatit)

esim. @-merkin rivin alussa sisältävät kohdat goto-komentoa varten

Skriptin suoritusmoottori (käy skriptin rivi riviltä läpi ja suorittaa validit komennot)
Syntaksi-info
Virheiden käsittelyä jokaiselle komennolle

Jos näissä ei ole tarpeeksi tekemistä tms., niin toiminnallisuuksiin saattaisi voida lisätä mahdollisuuden
nauhoittaa skriptejä (tosin ainoastaan hiiren liikkeet ja mahdollisesti kirjoittaminen ovat ainoat mitä tähän tulisi)
Lisäksi jos tosiaan aikaa on liikaa, niin voisin yrittää perehtyä suoritettavan rivin "highlightaamiseen".
