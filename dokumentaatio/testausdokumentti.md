# Testausdokumentti

## Automaattinen testaus

Käytössä on JUnit-testiluokka, tällä hetkellä automaattiset testit kattavat lähinnä Board-luokan, testikattavuutta tullaan parantamaan.
Testit voi suorittaa komentorivillä komennolla 

```
cd TicTacToe/TicTacToe
mvn test
```

Tällä hetkellä kaikki testit menevät läpi. 

## Ohjelman toiminnallisuuksien käyttäjätestaus

Ohjelmassa ei ole vielä syötteen validiointia. Virhesyöte johtaa ohjelman kaatumiseen.
Ohjelma tunnistaa voittajan, mikäli pelin voittorivi on yhtä pitkä kuin ristikon sivut, peli ei tunnista jos voittorivi kulkee matriisin diagonaalia oikeasta ylänurkasta vasempaan alanurkkaan.
Minimax-algoritmi ei vielä tee kaikilta osin älykkäitä päätöksiä, sen pitäisi olla mahdoton voittaa.
