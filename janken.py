import random

validChoices = {1:'rock', 2:'paper', 3:'scissors'}

def evalOutcome(playerMove, aiMove):
    print('*' * 25)
    print('Player\'s move: ' + playerMove)
    print('AI\'s move: ' + aiMove)

    if playerMove == aiMove:
        print('Draw!')
    elif playerMove == validChoices[1]: #rock
        if aiMove == validChoices[2]:   
            print('paper beats rock! AI wins!')
        elif aiMove == validChoices[3]:
            print('rock beats scissors! You win!')
    elif playerMove == validChoices[2]: #paper
        if aiMove == validChoices[1]:
            print('paper beats rock! You win!')
        elif aiMove in validChoices[3]:
            print('scissors beats paper! AI wins!')
    elif playerMove in validChoices[3]: #scissors
        if aiMove in validChoices[1]:
            print('rock beats scissors! AI wins!')
        elif aiMove in validChoices[2]:
            print('scissors beats paper! You win!')

while True:
    choice = input('Choose rock, paper, or scissors: ')
    if choice not in validChoices.values():
        print('Invalid input')
        continue

    aiChoice = validChoices[random.randrange(1,4)]
    print('AI Choice = ' + aiChoice)
    evalOutcome(choice, aiChoice)
    print('\nPlayer again(y/n)?')
    continuePlaying = input()
    if continuePlaying.lower() != 'y':
        break
