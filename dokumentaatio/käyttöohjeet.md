vko1:<br>
<br>
Paina mikropipetin kuvaa (labelia) aloittaaksesi värin tunnistuksen kursorin alla.<br>
Klikkaa hiiren vasemmalla painikkeella framen ulkopuolelle valitaksesi värin.<br>
Luo uusi skripti valitsemalla File-valikosta "New Script".<br>
 -Ohjelma tämän jälkeen kysyy, että haluatko tallentaa nykyisen skriptin.<br>
 --Jos vastaa kyllä, niin silloin avataan tallennusikkuna, josta voi visuaalisen käyttöliittymän avulla navigoida haluttuun sijaintiin.<br>
 ---Save tallentaa skriptin muodossa *.gms ts. Great MacroScript file.<br>
 ---Cancel peruuttaa tallentamisen.<br>
 --Jos vastaa ei, niin skriptille varattu tekstikenttä tehjennetään.<br>
 --Jos kyselyikkunan sulkee, niin palataan pääikkunaan ilman muutoksia.<br>
 Tallenna skripti valitsemalla File-valikosta "Save Script".<br>
 -Aukeaa tallennusikkuna, josta voi visuaalisen käyttöliittymän avulla navigoida haluttuun sijaintiin.<br>
 --Save tallentaa.<br>
 --Cancel peruuttaa.<br>
 Avaa skripti valitsemalla File-valikosta "Load Script".<br>
 -Aukeaa tiedoston avaamista varten visuaalinen käyttöliittymä, josta voi etsiä avattavan tiedoston.<br>
 --Open avaa tiedoston.<br>
 --Cancel peruuttaa.<br>
 Lopeta ohjelma joko tavanomaisesta sulkemispainikkeesta (joka yleensä sijaitsee ikkunan yläreunassa) tai valitsemalla File-valikosta "Exit".<br>
 <br>
 Hiiren positio yhden näytön sisältävissä järjestelmissä näytetään pääikkunalla sijaitsevissa kentissä, päivittyy testaustarkoituksia varten 100 ms intervallein.<br>
 <br>
 Ei vielä muita toiminnallisuuksia.<br>
<br>
vko2:<br>
<br>
Skriptin toiminnallisuudet tähän mennessä: <br>
 -goto (komento ohjaa skriptin takaisin @-tunnisteella merkittyyn stringiin)<br>
   VAROITUS: TÄLLÄ HETKELLÄ TÄMÄ JOHTAA LOPUTTOMAAN LOOPPIIN, KOSKA int-MUUTTUJIEN KOODAUS ON KESKEN!<br>
   Eli paikka määritellään: @asd<br>
   Komentoa kutsutaan goto asd<br>
 -sleep (komento laittaa skriptin odottamaan millisekunneissa määritellyksi ajaksi)<br>
   Esim. sleep 1000<br>
 -int (vain muuttujan arvon asettaminen)<br>
  Esim. int i=100<br>
 -mouseLeftDown<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -mouseLeftUp<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -mouseRightDown<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -mouseRightUp<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -setMousePos<br>
  Kyseinen komento asettaa hiiren osoittimen haluttuihin koordinaatteihin arvoilla x y.<br>
  Esim. setMousePos 200 200<br>
 -mouseLeftClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -mouseRightClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -mouseHumanLeftClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -mouseHumanRightClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.<br>
 -keyDown (painaa näppäimistön painikkeen pohjaan)<br>
  Esim. keyDown a<br>
 -keyUp (nostaa näppäimistön painikkeen pohjasta)<br>
  Esim. keyUp a<br>
 -type (kirjoittaa tekstin nopeasti)<br>
  Esim. type asdasd<br>
 -typeHuman (kirjoittaa tekstin imitoiden ihmistä, paitsi ettei paina vääriä nappeja)<br>
  Esim. typeHuman asdasd<br>
 -moveMouseSmooth (liikuttaa hiiren kursorin suorinta reittiä pikseli kerrallaan annettuihin koordinaatteihin)<br>
  Esim. moveMouseSmooth 1 1<br>
sisältää tällä hetkellä myös testikomennon mm, joka ei tee mitään.<br>
Virheiden käsittely on olematonta, joten jos ei kaikki mene täysin oikein, tapahtuu outoja asioita.<br>
<br>
vko3:<br>
<br>
 -moveMouseHuman (liikuttaa hiiren kursoria mutkittelevaa reittiä annettuihin koordinaatteihin)<br>
  Esim. moveMouseHuman 1 1<br>
 <br>
 vko4:
  -if lauseiden alkeellinen käsittely. Pitäisi toimia muodossa if (int muuttuja)=(integer arvo) (komento).<br>
   Esim. if i=3 setMousePos 1 1<br>
  -findColor, findColorFromPalette, findColorStartingFromPoint, findColorFromPaletteStartingFromPoint metodeja ei ole vielä kytketty toimintaan, koska nämä ovat jokseenkin turhia, ellei niitä saa kytkettyä parametriksi esim. setMousePos komennolle.
