# MDM4U-Culminating-Game-Project-Balance-at-the-Third （BATT）

## Game Rule
The rules of the game are very simple: The dealer draws one card from a standard deck of 52 cards (excluding jokers). This card is used in all three rounds thereafter. Players place bets.
    
    Round 1: Guess the suit (hearts, diamonds, spades, clubs).
    
    Round 2: Guess whether the card is a number or letter (2-10, JQKA).
    
    Round 3: Guess the specific card.
A correct guess earns the player a win; a wrong guess results in losing everything. A player who guesses correctly can choose to fold after the results of the first or second round (keeping their winnings).

---
## Deck structure and stage progression demonstration
### Stage-wise Expected Value Table (3% advantage to the house)
<img width="873" height="415" alt="image" src="https://github.com/user-attachments/assets/668f5d94-1c1f-4933-96a9-aa7fa332b5c2" />
### Tree Diagram
<img width="1524" height="865" alt="屏幕截图 2026-04-22 230339" src="https://github.com/user-attachments/assets/ad4e6b08-c8d8-4227-93c1-3659d2eb2a0e" />

---
## Theoretical probability calculation
<img width="1551" height="622" alt="image" src="https://github.com/user-attachments/assets/1ba3d393-8f6d-460c-821f-c55446927d37" />

---
## Experimental data
I use Java to do the experiment, it allows me to collect huge amount of data. And I collect 900,000 datas. The Player's Win Rate is 1.9%. Experimental Expected Rate of Return is (Total revenue - input cost) / Input cost = （8,665,851 coin - 9,000,000 coin）/ 9,000,000 coin = -0.0371 = -3.71%. The data is very close to 3% advantage to the house, which means its acurate.
<img width="999" height="672" alt="image" src="https://github.com/user-attachments/assets/d4bfb600-31d4-4648-a9af-44d91a23b0a6" />
<img width="1726" height="1418" alt="image" src="https://github.com/user-attachments/assets/d0119b12-93f8-444e-82d3-9961f07adc02" />
