# Testausdokumentti

## Automaattinen testaus

Käytössä on JUnit-testipakkaus ja automatisoidut testit. Automaattiset testit kattavat Board-, AI- ja Controls-luokat. 
Testit saa ajettua komentorivillä:

```
cd TicTacToe/TicTacToe
mvn test
```

Tällä hetkellä kaikki testit menevät läpi. 

Testikattavuus on Jacoco-testikattavuusraportin mukaan 96%. Testikattavuusraporttiin ei ole sisällytetty käyttöliittymäluokkaa.

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/kuvat/jacoco_20200626.png)

### Ohjelman TestClass-testiluokka ja sen ajaminen

Ohjelmaan on kirjoitettu myös TestClass-testiluokka, jossa on simuloitu valmiiksi muutama peli. 
Ensimmäisessä pelissä on perinteinen 3x3-peli, jossa pelaaja tekee rationaalisia valintoja ja päättyy tasapeliin.
Toisessa pelissä pelaaja tekee virheen ja AI voittaa heti kolmannella vuorolla.
Kolmas peli on 4x4-peli, jossa voittorivi on 3. 
Pelaaja tekee rationaalisia valintoja, mutta päätyy silti häviämään koska AI saa aloittaa pelin. 
TestClass-luokka tulostaa aina pelitilanteen konsolille ja tulostaa, kauanko AI:lla meni aikaa. 
AI:n vuorojen kestot otetaan ylös jokaisesta pelistä omaan taulukkoonsa (ensimmäinen peli taulukoidaan omaan taulukkoonsa, sarakkeissa on vuorot, riveillä eri testien tulokset koska testit toistetaan 20 kertaa). 
Taulukoidut testitulokset tulostuvat ohjelman päätteeksi konsolille.
Testiohjelman voi ajaa muokkaamalla ui-pakkauksen Main-metodia poistamalla kommenttimerkit rivin 15 koodin edestä (tässä kohdassa kutsutaan testiluokan test()-metodia) ja vastavuoroisesti kannattaa lisätä kommenttimerkinnät rivin 17 koodille.

## Ohjelman toiminnallisuuksien käyttäjätestaus

Ohjelmassa on syötteen validiointi, virhesyötteistä ohjelma pyytää syöttämään uudelleen.
Ohjelma tunnistaa voittajan annetulla voittorivin pituudella kaikkiin suuntiin (rivit, sarakkeet, diagonaalit). 
Tämä on tarkistettu sekä käyttäjätestauksella että automaattisilla JUnit-testeillä.
Tekoälyä ei voi voittaa perinteisessä 3x3 -ruudukon pelissä, jossa voittorivi on 3, peli päättyy joko AI:n voittoon tai tasapeliin.
4x4 ruudukossa, jossa voittorivi on 3, voittaja on aina se, joka aloittaa pelin (olettaen, että ihminen tekee rationaalisia päätöksiä). 
4x4 -ruudukossa tulee minimaxin syvyysraja mukaan, syvyysrajoituksen 5 ja 6 välillä on melko selkeä ero sekä suoritusajassa että AI:n älykkyydessä.
