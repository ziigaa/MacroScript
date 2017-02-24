  **Käyttöohjeet:**<br><br>
  
Käyttöliittymän ominaisuudet:<br>
-Luo uusi skripti (ensin herjaa, että haluatko tallentaa)<br>
-Tallenna skripti (Buffered)<br>
-Avaa skripti (Buffered)<br>
-Suorita skripti<br>
-Virheilmoitusikkuna<br><br>

-Hiiren position seuraaminen timerin avulla (yhden näytön sisältävissä järjestelmissä)<br><br>

Värin valitseminen aloitetaan painamalla framella olevaa sinistä mikropipetin kuvaa.
-Värin tunnistaminen kursorin alta kun toiminto on aktivoitu, lopetus kun jFrame menettää fokuksensa<br>
-Värin esitetään jLabelissa silloin, kun toiminto on aktiivisena.<br>
-Värin esitetään hex-muodossa tekstikentässä (skriptissä käytettyjen värinetsimiskomentojen vuoksi)<br><br>
  
**if-lauseet:**<br>
-(Huom! if-lauseen toiminta rajoittuu näihin!):<br>
--if muuttuja=toinen_muuttuja komento<br>
--tai<br>
--if muuttuja=int_arvo komento<br>
--komento voi olla mikä vain näissä käyttöohjeissa määritely komento.
--esim. if i=3 setMousePos 1 1 tai if i=j setMousePos 1 1)<br>
--if värinetsintäfunktio komento<br>
--(Tarkoittaa sitä, että jos väri löytyy, niin tehdään komento-osuus.)<br>
--esim. if findColor #000000 0 0 40 40 setMousePos 1 1<br>
--(Tämä etsisi mustaa väriä näytön alueelta x1=0, y1=0, x2=40, y2=40 ja jos sieltä löytyy musta väri, niin siirretään hiiri koordinaatteihin x=1, y=1.)<br>
--toinen tapa:<br>
--if findColorFromPaletteStartingFromPoint #000000 20 20 100 100 60 60 setMousePos findColorFromPaletteStartingFromPoint #000000 20 20 100 100 60 60<br>
--(Tässä hieman monimutkikkaammassa versiossa (mustan=#000000) värin haku aloitetaan koordinaateista x=60, y=60 ja etsitään siitä pisteestä ulospäin ja jos väri löytyy alueelta x1=20, y1=20, x2=100, y2=100, niin asetetaan hiiri näihin koordinaatteihin (mikäli väri ei ole tässä todella lyhyessä ajassa ehtinyt katoamaan sieltä).)<br><br>
**goto** (Ainoastaan esim. @-merkillä spesifioituihin kohtiin)<br>
-Oletetaan, että skriptissä on rivi, joka sisältää syötteen "@kohta". Tällöin goto-komento toimii seuraavanlaisesti: goto kohta<br>
--Tällöin skripti etenee @kohta syötteen sisältämästä rivistä alaspäin.<br>
**sleep** (Odotustoiminto millisekunneissa). Syntaksi: sleep aika(integerinä)<br>
-esim. sleep 1000<br>
**colorPalette** (Kirjoitusasultaan muunneltu arraylist muuttuja johon syötetään värit hex-muodossa). Syntaksi colorPalette #väri1 #väri2 #väri3 ...<br>
-esim. colorPalette #000000 #FFFFFF<br>
-Huom! Käyössä on ainoastaan yksi colorPalette, joten muuttujan nimeä ei tarvitse määrittää.<br>
**int (muuttuja)**<br>
-esim int i<br>
-tai int i=3<br>
-tai int i=j<br>
--(Jos j on jo entuudestaan määritelty)<br>
int muuttujien peruslaskutoimitukset, eli +, -, *, /.<br><br>
*) muuttuja=numero(operaatio)numero tai muuttuja=muuttuja(operaatio)numero tai muuttuja(operaatio)muuttuja+muuttuja tai muuttuja=numero(operaatio)muuttuja.<br>
--(operaatio) voi olla mikä tahansa yllä mainituista.<br>
--esim. i=i/j<br>
-Huom! Kaikki arvot palautuvat int-arvoina, vaikka ne todellisuudessa olisivatkin desimaalilukuja.<br><br>

Hiiren komentoja (MouseOperator):<br>
**mouseLeftDown** (Hiiren vasen nappi alas, missä ikinä hiiri onkaan)<br>
-esim. mouseLeftDown<br>
**mouseLeftUp** (Hiiren vasen nappi ylös, missä ikinä hiiri onkaan)<br>
-esim. mouseLeftUp<br>
**mouseRightDown** (Hiiren oikea nappi alas, missä ikinä hiiri onkaan)<br>
-esim. mouseRightDown<br>
**mouseRightUp** (Hiiren oikea nappi ylös, missä ikinä hiiri onkaan)<br>
-esim. mouseRightUp<br>
**setMousePos** (Asettaa kursorin sijainnin).<br>
Syntaksi: setMousePos x y<br>
-esim. setMousePos 1 1<br>
TAI koordinaattiparametrien tilalla voidaan käyttää myös värinetsintä toimintoa, jolloin kirjoitus asu on seuraavanlainen:<br>
setMousePos VärinEtsintäFunktio Parametrit<br>
-esim. setMousePos findColor #000000 20 20 80 80<br>
Tällöin setMousePos suoritetaan koordinaatteihin, joista väri #000000 on löytynyt jos se löytyy määritellyltä alueelta.<br>
**moveMouseSmooth** (Liikuttaa hiirtä taloudellisinta laskettua rataa pitkin (ottaen huomioon, että liikutus tapahtuu 1 pikseli kerrallaan joko viistottain, vertikaalisesti tai horisontaalisesti) kohdepisteeseen, itse metodi sisältää nopeuteen vaikuttavan tekijän, mutta tätä ei pääse ohjelmassa hallitsemaan. Vakionopeus on 1 pikseli 3:ssa millisekunnissa) Syntaksi: moveMouseSmooth x y<br>
-esim. moveMouseSmooth 100 100<br>
TAI koordinaattiparametrien tilalla voidaan käyttää myös värinetsintä toimintoa, jolloin kirjoitus asu on seuraavanlainen:<br>
moveMouseSmooth VärinEtsintäFunktio Parametrit<br>
-esim. moveMouseSmooth findColor #000000 20 20 80 80<br>
Tällöin moveMouseSmooth suoritetaan koordinaatteihin, joista väri #000000 on löytynyt jos se löytyy määritellyltä alueelta.<br>
**moveMouseHuman** (Liikuttaa hiirtä "ihmismäisesti", eli epäsuoraa reittiä, määritettyihin koordinaatteihin ja yleensä ei osu täsmälleen syötettyihin koordinaatteihin). Syntaksi moveMouseHuman x y<br>
-esim. moveMouseHuman 50 70<br>
TAI koordinaattiparametrien tilalla voidaan käyttää myös värinetsintä toimintoa, jolloin kirjoitus asu on seuraavanlainen:<br>
moveMouseHuman VärinEtsintäFunktio Parametrit<br>
-esim. moveMouseHuman findColor #000000 20 20 80 80<br>
Tällöin moveMouseHuman suoritetaan koordinaatteihin, joista väri #000000 on löytynyt jos se löytyy määritellyltä alueelta.<br>
**mouseLeftClick** (Hiiren vasen nappi alas ja ylös tehokkaimmalla tavalla, missä ikinä hiiri onkaan)<br>
-esim. mouseLeftClick<br>
**mouseRightClick** (Hiiren oikea nappi alas ja ylös tehokkaimmalla tavalla, missä ikinä hiiri onkaan)<br>
-esim. mouseRightClick<br>
**mouseHumanLeftClick** (Ero mouseLeftClick:iin on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja ja painallusta edeltävä pieni pysähdys)<br>
-esim. mouseHumanLeftClick<br>
**mouseHumanRightClick** (Ero mouseRightClick:iin on napin pohjassaoloaikaan vaikuttava satunnainen muuttuja ja painallusta edeltävä pieni pysähdys)<br>
-esim. mouseHumanRightClick<br><br>

Näppäimistön komentoja (KeyboardOperator):<br><br>
Huom! Sallitut merkit kaikissa syötteen vaatimissa kohdissa ovat ovat enkkuaakkoset a-z isoina kirjaimina tai pieninä kirjaimina ja numerot 0-9 sekä välilyönti. Muita sallittuja merkkejä ovat: !"#¤%&/()=,.-<br>
Nämä painallukset ovat kuitenkin määritetty suomenkielisen näppäimistöulkoasun mukaisesti käytänöön syistä, joten kun isoihin kirjaimiin tai erikoismerkkeihin tarvitsee suomenkielisen näppäimistön mukaan käyttää shiftiä, niin skripti käyttää shiftiä.<br><br>
**keyDown** (Näppäin alas, fokus määrittää mihin napin painallus menee ja skripti ei ota tähän millään tavalla itsestään kantaa). Syntaksi: keyDown char<br>
-esim. keyDown a<br>
**keyUp** (Näppäin ylös, fokus määrittää mihin napin pohjasta päästäminen menee ja skripti ei ota tähän millään tavalla itsestään kantaa). Syntaksi: keyUp char<br>
-esim. keyUp a<br>
**pressEnter** (Painaa enter-näppäintä, fokus määrittää mihin napin painallus menee ja skripti ei ota tähän millään tavalla itsestään kantaa).<br>
-esim. pressEnter<br>
**type** (Kirjoittaa nopeimmalla tavalla syötteessä annetun tekstin, fokus määrittää mihin teksti menee ja skripti ei ota tähän millään tavalla itsestään kantaa). Syntaksi: type tekti<br>
-esim. type tralalaa olen onnellineeeeen<br>
**typeHuman** (Kirjoittaa syötteessä annetun tekstin tavalla, jossa kunkin painalluksen pohjassaoloaikaan vaikuttaa satunnainen viiveluku. Sama vaikuttaa intervalliin napin painalluksien välillä. Fokus määrittää mihin napin painallus menee ja skripti ei ota tähän millään tavalla itsestään kantaa). Syntaksi: typeHuman teksti<br>
-esim. typeHuman hihihihihii hahahahahaahaaa hohohohohohohooo<br><br>

Parametreinä tai if-lauseen ehtoina (ColorOperator):<br>
**findColor** (etsii näytöltä pisteen, joka on annetun syötteen (hex) värinen syötettyjen nelikulmion koordinaattien sisältä ja palauttaa sen koordinaatit). Syntaksi #väri vasenX ylempiY oikeaX alempiY<br>
-esim. findColor #000000 0 0 40 40<br>
**findColorFromPalette** (etsii näytöltä pisteen, joka on colorPalette-muuttujan sisältämän syötteen värinen, syötetyn nelikulmion koordinaattien sisältä ja palauttaa sen koordinaatit). Syntaksi: findColorFromPalette vasenX ylempiY oikeaX alempiY<br>
-esim. findColorFromPalette 20 20 80 80<br>
**findColorStartingFromPoint** (etsii näytöltä spiraalimaisesti syötteellä määritetyn värin sisältämän pisteen annetuista koordinaateista lähtien ulospäin, syötettyjen nelikulmion muodostavien koordinaattien sisältä ja palauttaa sen koordinaatit). Syntaksi: findColorStartingFromPoint #väri vasenX ylempiY oikeaX alempiY alkuX alkuY<br>
-esim. findColorStartingFromPoint #000000 30 30 100 100 65 65<br>
**findColorFromPaletteStartingFromPoint** (etsii näytöltä spiraalimaisesti colorPalette-muuttujassa määritetyn värin sisältämän pisteen annetuista koordinaateista lähtien, syötettyjen nelikulmion muodostavien koordinaattien sisältä ja palauttaa sen koordinaatit). Syntaksi: findColorFromPaletteStartingFromPoint vasenX ylempiY oikeaX alempiY alkuX alkuY<br>
-esim. findColorFromPaletteStartingFromPoint 60 60 200 200 130 130<br><br>

Erikoistapaus:<br>
**@-merkin** rivin alussa sisältävät kohdat. Näiden tulkitaan olevan goto-komentoa varten ja täten niiden jälkeen tuleva teksti tallennetaan rivinumeron kera, minkä jälkeen skriptin voi goto komennolla kutsua jatkuvaksi tästä kohdasta.<br>
-Esimerkki kohdan määrittämisestä:<br>
@kohta<br>
Kohdan kutsuminen goto-komennolla: kts. goto-komento.<br><br>

Kaikki komennot ovat CaSeSeNsItIvE.<br><br>

Ohjelma sisältää virheiden käsittelyä jokaiselle komennolle, joista saa vapaavalintaisesti käytössä olevaan loggeriin ystävällisiä huomautuksia. Jos oikein pahasti tyrii, niin saa useamman samasta asiasta :)<br>
