# Project Emily

Emily is 'artificial intelligence' chatbot & smart asistent.

## Dev todo
- [X] Basic Structure
- [X] Reset all responses usages count at 00:00
- [X] Database structure
- [X] Own database of basic phrases
- [X] Phrases database (word-meaning explanation)
- [X] Memory system (First boot time etc.)
- [X] CLI Chat system
- [X] Input validation system
- [X] Input recognition system
- [X] Responses to inputs in database.json
- [X] Log system (logs: not found inputs, found inputs, system actions, overused usages)
- [X] Self-preservation system (Anti-removal, shutdown)
- [X] Random question system (For example At night, ask if the user is tired) [on start]
- [X] Database jsons create source -> resources
- [ ] Voice system

## Static responses functions todo
- [X] Time check (What time is it?)
- [X] What day it is? response
- [ ] Who you are? response
- [ ] Emergency shutdown system
- [ ] Say function (say [msg to say]) response
- [ ] Help function (display emily's features) response
- [ ] Who is your creator?
- [ ] What does {phrase} mean (answer from phrase database = word-meaning-database.json)
- [ ] How old are you and similar questions (answer from the memory system = memory.json)
- [ ] Calculator
- [ ] Creating scenarios and situations
- [ ] Internet search assistant
- [ ] Language recognition
- [ ] Personality system (opinions, favorite color, game, music, etc. [in memory.json file])...
- [ ] Controlling computer (example: shutdown, update, file system clean, etc)
- [ ] Learning system (inputs/responses database)

## Dependencies
This project requires Java 17.
* Junit
	* Version: **4.11**
	* [Website](https://junit.org/junit5/)
* Json-Simple
	* Version: **1.1.1**
	* [Website](https://code.google.com/archive/p/json-simple/)
