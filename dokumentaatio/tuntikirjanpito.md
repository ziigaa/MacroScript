### Tuntikirjanpito
Päivä | Tunnit | Kuvaus
--------------- | ----- | ------
19.01.2017 | 12h | -GUI<br>-Save<br>-Load<br>-Hiiren position seuraaminen timerin avulla (yhden näytön sisältävissä järjestelmissä)<br>-Värin tunnistaminen kursorin alta kun toiminto on aktivoitu, lopetus kun jFrame menettää fokuksensa<br>-Värin esittäminen jLabelissa<br>-Värin esittäminen hex-muodossa tekstikentässä (mahdollisesti skriptissä toteutettavia värin etsimiskomentoja varten)
20.01.2017 | 6h | -Github<br>-Kuvaus<br>-Labtool<br>-ym. säätöä<br>-Ohjeiden kirjoittaminen<br>-Kansiorakenteen ja valmiiden tiedostojen luominen reposirotioon
24.01.2017 | 6h | -Luokka MouseOperator (funktioilla leftDown, leftUp, leftClick, leftHumanClick, rightDown, rightUp, rightClick, rightHumanClick, setMousePosition, moveMouseSmooth(aloitettu, hakee nyt ainoastaan kursorin sijainnin)).<br>-Luokka KeyboardOperator (ilman ääkkösiä, tosin tutkimusta on tehty) (funktioilla keyDown, keyUp, type, getChar, prepareToType, doType, doHumanType)
25.01.2017 | 6h | -Luokka ScriptMotor (funktioilla splitIntoLines, runScript, executeCommand)<br>
--executeCommand metodin toiminnallisuudet tähän mennessä: goto, sleep, int, mouseLeftDown, mouseLeftUp, mouseRightDown, mouseRightUp, setMousePos, mouseLeftClick, mouseRightClick, mouseHumanLeftClick, mouseHumanRightClick, keyDown, keyUp, type, typeHuman)<br>
---sisältää tällä hetkellä myös testikomennon mm, joka ei tee mitään.<br>
---sisältää myös int-tyyppisen muuttujan arvon asettamisen.
03.02.2017 | 5h | -moveMouseSmooth MouseOperatoriin<br>
-moveMouseHuman (kesken.........) MouseOperatoriin

07.02.2017 | 6h | -Luokkakaavio<br>
-Selvittely pit- ja checkstyle-raporttien oikein käytöstä<br>
-Tuntikirjanpidon fiksaus luettavampaan muotoon<br>
ColorOperator.java (sisältäen metodit: findColorStartingFromPoint, findColorFromPaletteStartingFromPoint, findColor, findColorFromPalette, getColorPaletteAsRGB, hexToRGB<br>-KeyboardOperator uusiksi, kompaktimpaan muotoon, kaikki oleellinen toiminnallisuus säilytetty.<br>

Tuntiraportti
--------0h---------
-GUI
-Save
-Load
-Hiiren position seuraaminen timerin avulla (yhden näytön sisältävissä järjestelmissä)
-Värin tunnistaminen kursorin alta kun toiminto on aktivoitu, lopetus kun jFrame menettää fokuksensa
-Värin esittäminen jLabelissa
-Värin esittäminen hex-muodossa tekstikentässä (mahdollisesti skriptissä toteutettavia värin etsimiskomentoja varten)

--------12h---------

-Github
-Kuvaus
-Labtool
-ym. säätöä

--------16h---------

-Ohjeiden kirjoittaminen
-Kansiorakenteen ja valmiiden tiedostojen luominen reposirotioon

--------18h---------

-Luokka MouseOperator (funktioilla leftDown, leftUp, leftClick, leftHumanClick, rightDown, rightUp, rightClick, rightHumanClick, setMousePosition, moveMouseSmooth(aloitettu, hakee nyt ainoastaan kursorin sijainnin)).
-Luokka KeyboardOperator (ilman ääkkösiä, tosin tutkimusta on tehty) (funktioilla keyDown, keyUp, type, getChar, prepareToType, doType, doHumanType)
-Luokka ScriptMotor (funktioilla splitIntoLines, runScript, executeCommand)
--executeCommand metodin toiminnallisuudet tähän mennessä: goto, sleep, int, mouseLeftDown, mouseLeftUp, mouseRightDown, mouseRightUp, setMousePos, mouseLeftClick, mouseRightClick, mouseHumanLeftClick, mouseHumanRightClick, keyDown, keyUp, type, typeHuman)
---sisältää tällä hetkellä myös testikomennon mm, joka ei tee mitään.
---sisältää myös int-tyyppisen muuttujan arvon asettamisen.

--------30h---------

-moveMouseSmooth MouseOperatoriin
-moveMouseHuman (kesken.........) MouseOperatoriin

-------35h----------
