# Viikon 6 raportti

![alt_text](https://media2.giphy.com/media/LRVnPYqM8DLag/200w.webp?cid=ecf05e470f0c4b05d6d6c6ef0998affc307ece7bb4e312a0&rid=200w.webp)

## Mitä tein tällä viikolla?

Tällä viikolla olen siistinyt ohjelmaa siten, että olen poistanut turhia taulukkorakenteita (kuten Board-luokan generoimaa taulukkoa, joka erikseen ilmoittaa vapaat sijainnit).
Olen myös muokannut voitontunnistusta ja ohjelmaa kokonaisuudessaan niin, että nyt käyttäjä syöttää myös haluamansa voittorivin pituuden.
Tämä on siis pistänyt kokonaan uusiksi voitontunnistusmetodin. Nyt ohjelma ei ainoastaan tunnista voittoa, mutta pystyy antamaan myös nimenomaisen ruudun positioarvon vuorossa olevan pelaajan näkökulmasta.
Jos siis esimerkiksi rivillä on jo kaksi ristiä niin Board-luokan positionValue-metodi antaa ko. position arvoksi 2.
Voitontunnistusmetodi on nyt myös sikäli tehokkaampi, että se ei käy joka kerta koko ristikkoa läpi, vaan ainoastaan sen rivin, sarakkeen ja ne diagonaalit, joihin viimeisin siirto vaikuttaa.
PositionValue-metodissa on vielä pieni bugi diagonaalien osalta, jota en nyt juhannuksen alla ehdi korjaamaan - ennen loppupalautusta kylläkin.

## Miten ohjelma on edistynyt?

Ohjelma toteuttaa nyt paremmin sitä alkuperäistä ideaa, että voittorivi on pelaajan päätettävissä. 
Ohjelma on nyt myös tehokkaampi, sillä se ei jokaisen vuoron päätteeksi iteroi lävitse koko ristikkoa, vaan ainoastaan ne rivit, sarakkeet ja diagonaalit, joihin viimeisin siirto vaikuttaa.
Diagonaalien osalta on vielä hieman bugia, mutta se tulee korjattua ennen loppupalautusta.

## Mitä opin tällä viikolla?

Hmm. Ristinollan säännöt ei ole niin yksinkertaista koodata kuin voisi kuvitella. Ainakaan jos saa itse päättää voittorivin koon.

## Mitä jäi epäselväksi?

PositionValue-metodista; kannattaako positionValueksi antaa 2 vai 3 jos halutaan tiedustella sellaisen rivin/sarakkeen/diagonaalin arvoa, jossa on jo kaksi omaa merkkiä.
Eli tavallaan olisiko järkevää, että ohjelma antaa position arvon *siirron jälkeen* vai *ennen siirtoa* (kuten nykyisellään).

## Mitä teen seuraavaksi?

Korjaan diagonaalibugin ja lisään vielä sääntöihin sen osuuden, jossa estetään vastapeluria voittamasta. 
Tähän minulla on jo melko selkeä ajatus (silloin kun vastustajan position arvo on yhden tai kahden pisteen päässä voitosta niin estä tämä).
Minimaxissa taitaa olla vielä joku pieni pulma, mutta helpompaa on ensin koodata säännöt valmiiksi. 
Olen tarvittaessa vielä ohjaajaan yhteyksissä ennen loppupalautusta mikäli ei meinaa toimia.
