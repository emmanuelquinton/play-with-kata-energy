A company's job is to sell energy on several markets.
There are 3 main markets:

- Primary Reserve
- Secondary Reserve
- the Rapid Reserve.

On each of these markets, the company can place a bid made up of several hourly "blocks" (a 24-hour day might contain 8 blocks of 3 hours).
Each hourly block shows the amount of energy (in MW) that will be produced, and a floor price below which it will not sell.

There are 3 types of electricity-generating parks
- solar
- wind
- hydroelectric

These parks are capable of supplying a certain number of MegaWatts for the duration of an hourly block.
To enable traceability of electricity production (guarantee of origin), we need to know which park(s) will produce the electricity for a given offer.

The aim of the kata is to implement APIs enabling :

- create an offer
- create a park
- list the offers proposed by the company for each market
- obtain the list of fleets selling on a given market.