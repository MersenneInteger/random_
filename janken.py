import random

validChoices = ['r', 'R', 'p', 'P', 's', 'S']

def printResult(move):
    if move in validChoices[0:2]:
        return 'rock'
    elif move in validChoices[2:4]:
        return 'paper'
    elif move in validChoices[4:6]:
        return 'scissors'

def evalOutcome(playerMove, aiMove):
    player = printResult(playerMove)
    ai = printResult(aiMove)
    print('*' * 25)
    print('Player chooses: ' + player)
    print('AI chooses: ' + ai)

    if player == ai:
        print('Draw!')
    elif playerMove in validChoices[0:2]: #rock
        if aiMove in validChoices[2:4]:   
            print('paper beats rock! AI wins!')
        elif aiMove in validChoices[4:6]:
            print('rock beats scissors! You win!')
    elif playerMove in validChoices[2:4]: #paper
        if aiMove in validChoices[0:2]:
            print('paper beats rock! You win!')
        elif aiMove in validChoices[4:6]:
            print('scissors beats paper! AI wins!')
    elif playerMove in validChoices[4:6]: #scissors
        if aiMove in validChoices[0:2]:
            print('rock beats scissors! AI wins!')
        elif aiMove in validChoices[2:4]:
            print('scissors beats paper! You win!')

while True:
    choice = input('Choose rock(r), paper(p), or scissors(s): ')
    if choice not in validChoices:
        print('Invalid input')
        continue

    aiChoice = validChoices[random.randrange(0,7)]
    evalOutcome(choice, aiChoice)
    print('\nPlayer again(y/n)?')
    continuePlaying = input()
    if continuePlaying.lower() != 'y':
        break
