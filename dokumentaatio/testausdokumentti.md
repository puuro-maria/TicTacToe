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

**Taulukot löytyvät tämän testausdokumentin lopusta.**

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/kuvat/TTT_AI_vuorot.PNG)

Kuten taulukoista *- mutta ei kuitenkaan ylläolevasta diagrammista -* näkee, AI:n vuorojen kesto ei aina ole automaattisesti lyhyempi pelin edetessä. 
4x4-kokoisen ristikon ensimmäinen vuoro kestää keskimäärin 0,8 sekuntia kun minimaxin syvyysrajoitus on 7.
Esimerkiksi viimeisessä taulukossa näkee, että vuoro 4 on merkittävästi vuoroa 5 lyhyempi - joskin ero on vain 0,002 sekuntia. 
Tämä johtuu AI-luokan bestMove-metodin rakenteesta; vuorossa 4 AI estää pelaajaa voittamasta, joten päätös on nopea, eikä minimax käy läpi läheskään niin montaa skenaariota kuin se normaalisti kävisi.
4x4-kokoisessa taulukossa toinen vuoro kestää keskimäärin 64% ensimmäisen vuoron kestosta, mikä viittaa siihen, että toisessakin vuorossa syvyysraja tulee vielä vastaan useissa skenaarioissa.
Vuoron 3 kohdalla ohjelma nopeutuu jo merkittävästi, vuoron 3 kesto on enää 5,5% toisen vuoron kestosta.
Viimeisen eli voittovuoron kesto on 0,00003% ensimmäisen vuoron kestosta.

## Ohjelman toiminnallisuuksien käyttäjätestaus

Ohjelmassa on syötteen validiointi, virhesyötteistä ohjelma pyytää syöttämään uudelleen.
Ohjelma tunnistaa voittajan annetulla voittorivin pituudella kaikkiin suuntiin (rivit, sarakkeet, diagonaalit). 
Tämä on tarkistettu sekä käyttäjätestauksella että automaattisilla JUnit-testeillä.
Tekoälyä ei voi voittaa perinteisessä 3x3 -ruudukon pelissä, jossa voittorivi on 3, peli päättyy joko AI:n voittoon tai tasapeliin.
4x4 ruudukossa, jossa voittorivi on 3, voittaja on aina se, joka aloittaa pelin (olettaen, että ihminen tekee rationaalisia päätöksiä). 
4x4 -ruudukossa tulee minimaxin syvyysraja mukaan, syvyysrajoituksen 5 ja 6 välillä on melko selkeä ero sekä suoritusajassa että AI:n älykkyydessä.

## TestClass-luokan testitulokset 


**Pelisimulaatio 1, jossa 3x3-peli päättyy tasapeliin. Ensimmäisellä rivillä keskiarvot.**

| Vuoro 1 | Vuoro 2 | Vuoro 3 | Vuoro 4 |
|:----------:|:------|:------|:---------|
| **14688113** | **1006028** | **70766** | **14274** |
| 115951840 | 4434190 | 578102 | 39062 |
| 12997192 | 1074342 | 70089 | 23084 |
| 9183837 | 800393 | 52582 | 15649 |
| 9021686 | 759505 | 61394 | 20312 |
| 9604294 | 760848 | 40961 | 18663 |
| 8943747 | 792723 | 42400 | 15050 |
| 8983672 | 798591 | 49923 | 13565 |
| 8685509 | 751466 | 56317 | 13876 |
| 9012623 | 742933 | 38903 | 11154 |
| 8705973 | 743154 | 38925 | 20153 |
| 9414699 | 1236106 | 35605 | 9399 |
| 9066936 | 807062 | 36738 | 10062 |
| 8795503 | 784667 | 45941 | 15359 |
| 8959895 | 754652 | 44990 | 9946 |
| 9870393 | 747340 | 37873 | 9424 |
| 10704956 | 776665 | 33073 | 7514 |
| 8897837 | 940749 | 47802 | 13772 |
| 8606640 | 728631 | 29236 | 5355 |
| 8994762 | 856139 | 41581 | 6968 |
| 9360280 | 830423 | 32904 | 7122 |

**Pelisimulaatio 2, jossa 3x3-peli päättyy AI:n voittoon pelaajan virheen takia. Ensimmäisellä rivillä keskiarvot.**

| Vuoro 1 | Vuoro 2 | Vuoro 3 | 
|:----------:|:------|:------|
| **13397719** | **776887** | **13179** |
| 92011823 | 1046925 | 24487 |
| 13671804 | 1128183 | 20576 |
| 8666354 | 706966 | 14573 |
| 8873855 | 724655 | 16268 |
| 8682948 | 715236 | 16985 |
| 10477790 | 800739 | 23546 |
| 8750902 | 716379 | 13847 |
| 8711020 | 717903 | 12917 |
| 9376928 | 717699 | 13243 |
| 8645273 | 720235 | 12848 |
| 8967749 | 695136 | 9302 |
| 9070010 | 757330 | 8039 |
| 8691446 | 698391 | 9597 |
| 8731507 | 694725 | 9572 |
| 8762351 | 711675 | 10025 |
| 9083227 | 690818 | 10765 |
| 9105228 | 713128 | 10008 |
| 8594223 | 678051 | 6142 |
| 8996843 | 747053 | 10648 |
| 10083108 | 1156519 | 10202 |

**Pelisimulaatio 3, jossa 4x4-peli 3 voittorivillä päättyy AI:n voittoon pelaajan rationaalisesta pelistä huolimatta. Minimaxin syvyysraja tässä testissä on 7. Ensimmäisellä rivillä keskiarvot.**

| Vuoro 1 | Vuoro 2 | Vuoro 3 | Vuoro 4 | Vuoro 5 | Vuoro 6 |
|:----------:|:------|:------|:-------|:-------|:-------|
| **804917846** | **518694403** | **28599622** | **801832** | **2902884** | **20833** |
| 1029667179 | 525755909 | 41731827 | 938767 | 4090041 | 33000 |
| 822413288 | 516249392 | 27342204 | 711612 | 2818467 | 20007 |
| 833028647 | 526526497 | 27862061 | 718591 | 2956789 | 19042 |
| 800484009 | 518850231 | 27999513 | 711866 | 2774602 | 28889 |
| 806110281 | 534059760 | 28257253 | 759755 | 2837012 | 16031 |
| 799118412 | 523084839 | 31031918 | 718850 | 2946501 | 15539 |
| 801010786 | 518947374 | 27114579 | 712404 | 2753071 | 13036 |
| 763930752 | 506087905 | 27146391 | 704969 | 2733439 | 22526 |
| 763117415 | 506021932 | 27120318 | 710692 | 2851396 | 13482 |
| 770150867 | 510550872 | 29585606 | 729988 | 2895957 | 12701 |
| 782094351 | 518778750 | 28150740 | 971150 | 3044538 | 9891 |
| 783237160 | 511421373 | 27205381 | 760612 | 2784273 | 8452 |
| 784070997 | 513480098 | 27117163 | 701155 | 2724859 | 9422 |
| 782156722 | 517201495 | 27197754 | 700971 | 2948914 | 11893 |
| 826412170 | 520801237 | 28543271 | 1544076 | 2777656 | 10149 |
| 801499464 | 517643413 | 27349829 | 987470 | 2878742 | 104850 |
| 772706918 | 519722684 | 27095548 | 706623 | 2693192 | 9473 |
| 786402277 | 525843506 | 28025941 | 758852 | 2885766 | 10822 |
| 777817066 | 511401580 | 27364224 | 762656 | 2755245 | 19921 |
| 812928158 | 531459223 | 28750919 | 725591 | 2907236 | 27549 |
