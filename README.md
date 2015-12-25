<snippet>
  <content>
# 1:LampSolver
This project was made to help battlefield 4 community to solve the lamp puzzle once its solution changes for each player.
## Installation
No installation needed. Just need java jre installed.
## Usage
First of all you need to follow this guide http://imgur.com/a/JHUQx and get all 7 switches and which lamps they effect. It's very important to enumarate the lamps and follow the same enumaration until the end of the process. These numbers are used to solve the puzzle using this algorithm. Once you collected the initial lamp configuration and all 7 switches you may change the file 'input.txt' with your own data, following this schema:
* The first line represents the lamps that are lit at the start of the round.
* The second line represents the Temple switch and which lamps it effects.
* The third line represents the Furnace switch and which lamps it effects.
* The forth line represents the Tree switch and which lamps it effects.
* The fifth line represents the Pier switch and which lamps it effects.
* The sixth line represents the Waterfall switch and which lamps it effects.
* The seventh line represents the Rock switch and which lamps it effects.
* The eighth line represents the Pagoda switch and which lamps it effects.

### Example
* Default lamps: 9 17
* Temple: 3 6 7 11 14 19
* Furnace: 1 2 5 12 13 15 16 18
* Tree: 5 6 7 14 15
* Pier: 5 15 20
* Waterfall: 9 17 20
* Rock: 2 9 16 17 18
* Pagoda: 1 3 4 8 10 11 12 13 19
* **Solution: Tree, Waterfall, Rock and Pagoda**

### Example Link
http://imgur.com/a/L8n3r

Then double click the LampSolver.jar file with the input file named 'input.txt' at the same directory and wait the for answer.

## F.A.Q.
1) What it is the lamp number i should use?

Doesnt matter. The problem is not about lamps and numbers but switchs and logical NOT operations. Fix a number for each lamp and it should run just fine. You can use [THIS](http://imgur.com/nNdTWnb).

2)Ok, i have the result, what to do next?

Just turn ON or OFF the buttons! It is that easy.

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D


## Credits
Chap0linColorado of [BTCO] BOTECO bf platoon.

## TODO
Anyone who wants to improve this community tool and make a more intuitive GUI, please do it. I dont have this kind of knowledge.
