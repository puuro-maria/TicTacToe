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
Ohjelma tunnistaa voittajan annetulla voittorivin pituudella kaikkiin suuntiin (rivit, sarakkeet, diagonaalit). 
Tekoälyä ei voi voittaa perinteisessä 3x3 -ruudukon pelissä, jossa voittorivi on 3, peli päättyy joko AI:n voittoon tai tasapeliin.
4x4 ruudukossa, jossa voittorivi on 3, voittaja on aina se, joka aloittaa pelin (olettaen, että ihminen tekee rationaalisia päätöksiä). 
4x4 -ruudukossa tulee minimaxin syvyysraja mukaan, syvyysrajoituksen 5 ja 6 välillä on melko selkeä ero sekä suoritusajassa että AI:n älykkyydessä.

AI:n siirron kesto ruudukon koon ja minimaxin syvyysrajan perusteella **ilman alfa-beeta-karsintaa**:

| Ruudukon koko, voittorivi | Syvyysraja | AI:n 1. vuoro kesto (ns)| AI:n 2. vuoro kesto (ns)| AI:n 3. vuoro kesto (ns) | AI:n viimeinen vuoro kesto | 
|:------------------:|:-------------|:-------------|:-----------------|:-----------------|:-----------|
| 3x3, 3 | - | 216841531 | 4742679 | 5606616 | 535745 |
| 4x4, 3 | 6 | 32212232587 | 7727989260 | 1660993803 | 207698481 |
| 4x4, 3 | 5 | 3677995273 | 1249392772 | 301542103 | 145805 |
