# Toteutusdokumentti :wrench:

## Ohjelman rakenne :house:

### Pakkausrakenne

Ohjelma on jaettu kolmeen eri pakkaukseen; **domain** sisältää tietorakenteet; pelilaudan ja Cell-olion, joka on joko risti tai nolla.
**Controls** -pakkaus sisältää sovelluslogiikan ja pelin tekoälyn eli minimax-algoritmin. **Ui** -pakkaus sisältää käyttöliittymän ja Main-luokan.

#### Pakkauskaavio

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/TicTacToe_pakkauskaavio.PNG)

### Luokkarakenne

Domain-pakkauksessa oleva **Board**-luokka sisältää ristinollapelin ristikon ja ristikon voittosäännöt. 
Itse ristikko on tehokkuuden vuoksi toteutettu 2D-taulukkona (int[][]), jonka arvot ovat 0, 1 tai -1. 
Domain-pakkauksessa sijaitseva **Cell**-enum sisältää kategoriset muuttujat *CROSS*, *CIRCLE* ja *BLANK*.

Controls-pakkausessa oleva luokka **AI** sisältää minimax- ja alfa-beeta-karsinnan algoritmit. 
Minimax on esitetty pseudokoodina määrittelydokumentissa. 
Controls-luokka sisältää sovelluslogiikan, jotta käyttöliittymässä ei tarvitse kutsua useita eri luokkia ja käyttöliittymä on eriytetty hyvin tietorakenteista.

Ui-pakkaus sisältää tekstikäyttöliittymän ja main-luokan.

## Aikavaativuus :hourglass_flowing_sand:

### Minimax-algoritmin aikavaativuus

Minimax-algoritmin aikavaativuus sellaisenaan on **O(b^n)**, jossa **b** on mahdollisten siirtojen määrä. 
Kun minimax-algoritmiin on lisätty alfa-beeta-karsinta, on aikavaativuus **O(b^(d/2))**, jossa **b** on edelleen mahdollisten siirtojen määrä ja **d** on algoritmin **syvyys**. 

Minimax-algoritmin tilavaativuus taas on **O(bn)**, sillä rekursiivisen rakenteen vuoksi jokaista mahdollista siirtoa kohden ohjelma luo uuden taulukon. 

### Board-luokan aikavaativuudet

Millaisia aikavaativuuksia Board-luokka tuo mukanaan? 
Board-luokassa on useita metodeja, jotka iteroivat taulukon läpi. 
Periaatteessa taulukon iteroiminen vie aina **O(n²)** aikaa, sillä ristikko on yhtä korkea kuin se on leveäkin. 
Vaikka peliä pelatessa taulukko tulee iteroitua läpi useaan otteeseen, ei vakiokertoimia sisällytetä aikavaativuuteen. 

### Yhden pelivuoron aikavaativuus

Mitä yhdessä pelivuorossa tapahtuu ja kauanko siinä menee? AI eli risti aloittaa. 

- AI:n vuoron alkaessa ohjelma tarkistaa, onko pelillä voittaja. Tähän menee aikaa vain **O(1)**, sillä pelin mahdollinen voittaja asetetaan aina siirron tapahtuessa.

- Jos pelillä ei ole voittajaa, ohjelma kutsuu AI-luokan bestMove-metodia, joka aloittaa peliristikon iteroinnin yksi ruutu kerrallaan, tähän menee **O(n²)**.

- Jokaisen ruudun kohdalla ohjelma selvittää ensin, onko tämä mahdollinen voittoruutu jos asetan ristin tähän. Tässä kohdassa kutsutaan Board-luokan positionValue-metodia, jonka aikavaativuus on **O(n²)** (kertoimia ei lasketa mukaan). Jos ko. ruutu on voittoruutu, ohjelma palauttaa tämän ruudun koordinaatit.

- Jos ko. ruutu ei ole voittoruutu, ohjelma tarkistaa positionValue-metodilla, onko tämä ruutu mahdollisesti *vastustajan* voittoruutu. Tähänkin menee sama **O(n²)**. Jos tämä on vastustajan voittoruutu, ruutu saa arvokkaan positionValuen, mutta iterointi ei pääty tähän, sillä seuraavahan voi olla vaikka oma voittoruutu ja se on toki kannattavaa valita mieluummin kuin estää vastustajaa voittamasta.

- Mikäli ruutu ei ole AI:n voittoruutu, se kutsuu minimax-algoritmia, jonka aikavaativuus on yllä mainittu **O(b^(d/2))**, jossa b on mahdollisten siirtojen määrä ja d on minimax-algoritmille annettu syvyysrajoitus. 

## Suoritusaikojen vertailua

Alla olevat testaukset on tehty yliopiston tietokoneella. Jokainen peli päättyi joko tasapeliin tai AI:n voittoon (4x4 ja 5x5 -kokoisissa peliristikoissa).

AI:n siirron kesto ruudukon koon ja minimaxin syvyysrajan perusteella **ilman alfa-beeta-karsintaa**:

| Ruudukon koko, voittorivi | Syvyysraja | AI:n 1. vuoro kesto (ns)| AI:n 2. vuoro kesto (ns)| AI:n 3. vuoro kesto (ns) | AI:n viimeinen vuoro kesto | 
|:------------------:|:-------------|:-------------|:-----------------|:-----------------|:-----------|
| 3x3, 3 | - | 216841531 | 4742679 | 5606616 | 535745 |
| 4x4, 3 | 7 | en jaksa odottaa | - | - | - |
| 4x4, 3 | 6 | 32212232587 | 7727989260 | 1660993803 | 207698481 |
| 4x4, 3 | 5 | 3677995273 | 1249392772 | 301542103 | 145805 |
| 5x5, 3 | 5 | en jaksa odottaa | - | - | - |

AI:n siirron kesto ruudukon koon ja minimaxin syvyysrajan perusteella **kun alfa-beeta-karsinta on käytössä**:

| Ruudukon koko, voittorivi | Syvyysraja | AI:n 1. vuoro kesto (ns)| AI:n 2. vuoro kesto (ns)| AI:n 3. vuoro kesto (ns) | AI:n viimeinen vuoro kesto | 
|:------------------:|:-------------|:-------------|:-----------------|:-----------------|:-----------|
| 3x3, 3 | - | 59174692 | 59174692 | 764302 | 764302 |
| 4x4, 3 | 7 | 1489454083 | 359343309 | 46669052 | 30747 |
| 4X4, 3 | 6 | 198148969 | 200373017 | 10195104 | 50143 |
| 4x4, 3 | 5 | 159722030 | 120794032 | 12199049 | 24464 |
| 5x5, 3 | 7 | 19522993734 | 9133110524 | 4112925522 | 34999858 |
| 5x5, 3 | 5 | 820900321 | 494547339 | 215121463 | 2802874 |

### Alfa-beeta-karsinnan vaikutus suoritusaikaan

Alfa-beeta karsinnan lisääminen minimax-algoritmiin tehostaa peliä siis merkittävästi. 
Alfa-beeta-karsinnan ollessa mukana AI:n ensimmäisen siirron viemä aika on yllä olevien testien perusteella vain n. 1-27 % pelkän minimaxin viemästä ajasta riippuen peliristikon koosta. Esimerkiksi 4x4-kokoisella ristikolla, jossa voittorivi on 3 ja syvyysmaksimi on 6, alfa-beeta-karsinnalla varustetulla algoritmilla meni ensimmäisen siirron löytämiseen 0,6% siitä ajasta, mikä pelkällä minimaxilla meni.

### Minimaxin syvyysrajoituksen vaikutus suoritusaikaan

Tietysti myös minimaxille annetulla syvyysrajoituksella on merkitystä ohjelman nopeuteen erityisesti pelin alkuvaiheessa. 
4x4-kokoisella peliristikolla oli vielä ihan mukavaa pelata syvyydellä 7. 
Kun syvyyttä sääti 6:een, ensimmäiseen siirtoon meni vain 13% 7-syvyisen algoritmin ajasta.
