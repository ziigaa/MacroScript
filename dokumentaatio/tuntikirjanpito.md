### Tuntikirjanpito
Päivä | Tunnit | Kuvaus
--------------- | ----- | ------
01.01.2016 | 1.5h | -GUI
-Save
-Load
-Hiiren position seuraaminen timerin avulla (yhden näytön sisältävissä järjestelmissä)
-Värin tunnistaminen kursorin alta kun toiminto on aktivoitu, lopetus kun jFrame menettää fokuksensa
-Värin esittäminen jLabelissa
-Värin esittäminen hex-muodossa tekstikentässä (mahdollisesti skriptissä toteutettavia värin etsimiskomentoja varten)
... | ... | ...

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
