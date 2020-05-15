# Sovelluksen määrittely

Sovellus toteutetaan Javalla. Sovellukseen käytetään perinteistä peleissä käytettyä minimax-algoritmia. 

## Minimax-algoritmi 

Pelin tekoäly tullaan toteuttamaan perinteisellä minimax-algoritmilla.
Minimax-algoritmi on peruuttavaan hakuun perustuva rekursiivinen algoritmi, joka arvioi vuorottain pelattavan pelin skenaariot tiettyyn syvyyteen asti.
Minimax-algoritmin käyttämä tietorakenne on puu. 
Puun kerrokset edustavat vuorotellen joko maksimoivan tai minimoivan pelaajan vuoroa. 
Maksimoivan pelaajan näkökulmasta algoritmi arvioi, että minimoiva pelaaja haluaa aina minimoida algoritmin lopputuloksen voittaakseen.
Maksimoiva pelaaja pyrkii saavuttamaan mahdollisimman suuren lopputuloksen (tässä tilanteessa 1). 
Tekoäly olettaa, että vastapeluri pyrkii aina valitsemaan vastustajansa kannalta huonoimman skenaarion. 
Jokaisen puun lehdissä on joko arvo 1, -1 tai 0 riippuen kyseisen skenaarion lopputulemasta.
Jos lehden arvo on 1, maksimoiva pelaaja voittaa, -1 jos minimoiva pelaaja voittaa ja tasapelin tullessa 0. 

### Minimax-puu havainnollistettuna

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/kuvat/minimaxpuu.PNG)

### Minimax pseudokoodina

```
function miniMax(node, depth, maxPlayer) { 
  if maxPlayer {
    value = -Infinity;
    for each child in node {
      value = max(value, miniMax(child, depth - 1, false)
      return value;
    }
  } else {
    value = Infinity;
    for each child in node {
      value = min(value, miniMax(child, depth - 1, true)
      return value;
    }
  }
}
```

**maxPlayer** on siis boolean-muuttuja, joka ilmoittaa algoritmille, täytyykö sen minimoida vai maksimoida tulos.
Rekursio tapahtuu kun halutaan selvittää, onko solmun lapsissa mahdollisesti suurempia tai pienempiä lopputulemia.
    
