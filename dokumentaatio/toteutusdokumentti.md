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
Periaatteessa taulukon iteroiminen vie aina **O(n^2)** aikaa, sillä ristikko on yhtä korkea kuin se on leveäkin. 
Vaikka peliä pelatessa taulukko tulee iteroitua läpi useaan otteeseen, ei vakiokertoimia sisällytetä aikavaativuuteen. 

### Yhden pelivuoron aikavaativuus

Mitä yhdessä pelivuorossa tapahtuu ja kauanko siinä menee?

## Suoritusaikojen vertailua

AI:n siirron kesto ruudukon koon ja minimaxin syvyysrajan perusteella **ilman alfa-beeta-karsintaa**:

| Ruudukon koko, voittorivi | Syvyysraja | AI:n 1. vuoro kesto (ns)| AI:n 2. vuoro kesto (ns)| AI:n 3. vuoro kesto (ns) | AI:n viimeinen vuoro kesto | 
|:------------------:|:-------------|:-------------|:-----------------|:-----------------|:-----------|
| 3x3, 3 | - | 216841531 | 4742679 | 5606616 | 535745 |
| 4x4, 3 | 6 | 32212232587 | 7727989260 | 1660993803 | 207698481 |
| 4x4, 3 | 5 | 3677995273 | 1249392772 | 301542103 | 145805 |
| 5x5, 3 | 5 | en jaksa odottaa | - | - | - |

AI:n siirron kesto ruudukon koon ja minimaxin syvyysrajan perusteella **kun alfa-beeta-karsinta on käytössä**:

| Ruudukon koko, voittorivi | Syvyysraja | AI:n 1. vuoro kesto (ns)| AI:n 2. vuoro kesto (ns)| AI:n 3. vuoro kesto (ns) | AI:n viimeinen vuoro kesto | 
|:------------------:|:-------------|:-------------|:-----------------|:-----------------|:-----------|
| 3x3, 3 | - | 59174692 | 59174692 | 764302 | 764302 |
| 4X3 | 125338741 | 
