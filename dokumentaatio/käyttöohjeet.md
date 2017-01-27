vko1:

Paina mikropipetin kuvaa (labelia) aloittaaksesi värin tunnistuksen kursorin alla.
Klikkaa hiiren vasemmalla painikkeella framen ulkopuolelle valitaksesi värin.
Luo uusi skripti valitsemalla File-valikosta "New Script".
 -Ohjelma tämän jälkeen kysyy, että haluatko tallentaa nykyisen skriptin.
 --Jos vastaa kyllä, niin silloin avataan tallennusikkuna, josta voi visuaalisen käyttöliittymän avulla navigoida haluttuun sijaintiin.
 ---Save tallentaa skriptin muodossa *.gms ts. Great MacroScript file.
 ---Cancel peruuttaa tallentamisen.
 --Jos vastaa ei, niin skriptille varattu tekstikenttä tehjennetään.
 --Jos kyselyikkunan sulkee, niin palataan pääikkunaan ilman muutoksia.
 Tallenna skripti valitsemalla File-valikosta "Save Script".
 -Aukeaa tallennusikkuna, josta voi visuaalisen käyttöliittymän avulla navigoida haluttuun sijaintiin.
 --Save tallentaa.
 --Cancel peruuttaa.
 Avaa skripti valitsemalla File-valikosta "Load Script".
 -Aukeaa tiedoston avaamista varten visuaalinen käyttöliittymä, josta voi etsiä avattavan tiedoston.
 --Open avaa tiedoston.
 --Cancel peruuttaa.
 Lopeta ohjelma joko tavanomaisesta sulkemispainikkeesta (joka yleensä sijaitsee ikkunan yläreunassa) tai valitsemalla File-valikosta "Exit".
 
 Hiiren positio yhden näytön sisältävissä järjestelmissä näytetään pääikkunalla sijaitsevissa kentissä, päivittyy testaustarkoituksia varten 100 ms intervallein.
 
 Ei vielä muita toiminnallisuuksia.

vko2:

Skriptin toiminnallisuudet tähän mennessä: 
 -goto (komento ohjaa skriptin takaisin @-tunnisteella merkittyyn stringiin)
   VAROITUS: TÄLLÄ HETKELLÄ TÄMÄ JOHTAA LOPUTTOMAAN LOOPPIIN, KOSKA int-MUUTTUJIEN KOODAUS ON KESKEN!
   Eli paikka määritellään: @asd
   Komentoa kutsutaan goto asd
 -sleep (komento laittaa skriptin odottamaan millisekunneissa määritellyksi ajaksi)
   Esim. sleep 1000
 -int (vain muuttujan arvon asettaminen)
  Esim. int i=100
 -mouseLeftDown
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -mouseLeftUp
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -mouseRightDown
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -mouseRightUp
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -setMousePos
  Kyseinen komento asettaa hiiren osoittimen haluttuihin koordinaatteihin arvoilla x y.
  Esim. setMousePos 200 200
 -mouseLeftClick
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -mouseRightClick
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -mouseHumanLeftClick
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -mouseHumanRightClick
  Kyseinen komento on kirjoitettu muodossa, jossa sitä kutsutaan ja se ei vaadi mitään parametrejä.
 -keyDown (painaa näppäimistön painikkeen pohjaan)
  Esim. keyDown a
 -keyUp (nostaa näppäimistön painikkeen pohjasta)
  Esim. keyUp a
 -type (kirjoittaa tekstin nopeasti)
  Esim. type asdasd
 -typeHuman (kirjoittaa tekstin imitoiden ihmistä, paitsi ettei paina vääriä nappeja)
  Esim. typeHuman asdasd

sisältää tällä hetkellä myös testikomennon mm, joka ei tee mitään.
Virheiden käsittely on olematonta, joten jos ei kaikki mene täysin oikein, tapahtuu outoja asioita.
