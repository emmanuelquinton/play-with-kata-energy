Quand un parc répond à une offre s'engage t'il pour tous les blocs horaires de l'offre ?
Plusieurs parc peuvent ils répondre à la même offre ?


Il fudrait le sens de l'aggregat:
parle ton plus souvent des marchés , des offres ou des park ?
si on parle des marché (market) on pourrait avoir comme api:
* GET  api/v1/markets/{idMarket}/offers 
* GET  api/v1/market/{idMarket}/parks
* POST api/v1/markets/{idMarket}/offers
* POST api/v1/market/{idMarket}/parks

```mermaid
---
title: Kata energy
---
classDiagram
    class `Offer`
    class `Market`
    class `TimeBlock`
    class `Park`

    `Offer` -->`Market`
    `Offer` o-- `TimeBlock`
    `Park` --> `TimeBlock`
`Park`


````

