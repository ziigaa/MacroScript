vko1:<br>
<br>
Paina mikropipetin kuvaa (labelia) aloittaaksesi v�rin tunnistuksen kursorin alla.<br>
Klikkaa hiiren vasemmalla painikkeella framen ulkopuolelle valitaksesi v�rin.<br>
Luo uusi skripti valitsemalla File-valikosta "New Script".<br>
 -Ohjelma t�m�n j�lkeen kysyy, ett� haluatko tallentaa nykyisen skriptin.<br>
 --Jos vastaa kyll�, niin silloin avataan tallennusikkuna, josta voi visuaalisen k�ytt�liittym�n avulla navigoida haluttuun sijaintiin.<br>
 ---Save tallentaa skriptin muodossa *.gms ts. Great MacroScript file.<br>
 ---Cancel peruuttaa tallentamisen.<br>
 --Jos vastaa ei, niin skriptille varattu tekstikentt� tehjennet��n.<br>
 --Jos kyselyikkunan sulkee, niin palataan p��ikkunaan ilman muutoksia.<br>
 Tallenna skripti valitsemalla File-valikosta "Save Script".<br>
 -Aukeaa tallennusikkuna, josta voi visuaalisen k�ytt�liittym�n avulla navigoida haluttuun sijaintiin.<br>
 --Save tallentaa.<br>
 --Cancel peruuttaa.<br>
 Avaa skripti valitsemalla File-valikosta "Load Script".<br>
 -Aukeaa tiedoston avaamista varten visuaalinen k�ytt�liittym�, josta voi etsi� avattavan tiedoston.<br>
 --Open avaa tiedoston.<br>
 --Cancel peruuttaa.<br>
 Lopeta ohjelma joko tavanomaisesta sulkemispainikkeesta (joka yleens� sijaitsee ikkunan yl�reunassa) tai valitsemalla File-valikosta "Exit".<br>
 <br>
 Hiiren positio yhden n�yt�n sis�lt�viss� j�rjestelmiss� n�ytet��n p��ikkunalla sijaitsevissa kentiss�, p�ivittyy testaustarkoituksia varten 100 ms intervallein.<br>
 <br>
 Ei viel� muita toiminnallisuuksia.<br>
<br>
vko2:<br>
<br>
Skriptin toiminnallisuudet t�h�n menness�: <br>
 -goto (komento ohjaa skriptin takaisin @-tunnisteella merkittyyn stringiin)<br>
   VAROITUS: T�LL� HETKELL� T�M� JOHTAA LOPUTTOMAAN LOOPPIIN, KOSKA int-MUUTTUJIEN KOODAUS ON KESKEN!<br>
   Eli paikka m��ritell��n: @asd<br>
   Komentoa kutsutaan goto asd<br>
 -sleep (komento laittaa skriptin odottamaan millisekunneissa m��ritellyksi ajaksi)<br>
   Esim. sleep 1000<br>
 -int (vain muuttujan arvon asettaminen)<br>
  Esim. int i=100<br>
 -mouseLeftDown<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -mouseLeftUp<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -mouseRightDown<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -mouseRightUp<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -setMousePos<br>
  Kyseinen komento asettaa hiiren osoittimen haluttuihin koordinaatteihin arvoilla x y.<br>
  Esim. setMousePos 200 200<br>
 -mouseLeftClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -mouseRightClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -mouseHumanLeftClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -mouseHumanRightClick<br>
  Kyseinen komento on kirjoitettu muodossa, jossa sit� kutsutaan ja se ei vaadi mit��n parametrej�.<br>
 -keyDown (painaa n�pp�imist�n painikkeen pohjaan)<br>
  Esim. keyDown a<br>
 -keyUp (nostaa n�pp�imist�n painikkeen pohjasta)<br>
  Esim. keyUp a<br>
 -type (kirjoittaa tekstin nopeasti)<br>
  Esim. type asdasd<br>
 -typeHuman (kirjoittaa tekstin imitoiden ihmist�, paitsi ettei paina v��ri� nappeja)<br>
  Esim. typeHuman asdasd<br>
 -moveMouseSmooth (liikuttaa hiiren kursorin suorinta reitti� pikseli kerrallaan annettuihin koordinaatteihin)<br>
  Esim. moveMouseSmooth 1 1<br>
sis�lt�� t�ll� hetkell� my�s testikomennon mm, joka ei tee mit��n.<br>
Virheiden k�sittely on olematonta, joten jos ei kaikki mene t�ysin oikein, tapahtuu outoja asioita.<br>
<br>
vko3:<br>
<br>
 -moveMouseHuman (liikuttaa hiiren kursoria mutkittelevaa reitti� annettuihin koordinaatteihin)<br>
  Esim. moveMouseHuman 1 1<br>
 <br>
 vko4:<br>
 <br>
  -if lauseiden alkeellinen k�sittely. Pit�isi toimia muodossa if (int muuttuja)=(integer arvo) (komento).<br>
   Esim. if i=3 setMousePos 1 1<br>
  -findColor, findColorFromPalette, findColorStartingFromPoint, findColorFromPaletteStartingFromPoint metodeja ei ole viel� kytketty toimintaan, koska n�m� ovat jokseenkin turhia, ellei niit� saa kytketty� parametriksi esim. setMousePos komennolle.<br><br>
  
 vko5:<br><br>
 
  -IfHandler muutettu SpecialCaseHandleriksi selke�mm�n kuvauksen vuoksi. Luokkaan lis�tty my�s metodit handleVariableSettingAndVariableCalculations(), createVariable(). Ym. toiminnallusuuteen liittyvi� p�ivityksi�.
  <br><br>
  
 vko6:<br><br>
  -Isoja p�ivityksia moneen asiaan liittyen. K�ytt�ohjeista yhteenveto alla.<br><br><br>
  