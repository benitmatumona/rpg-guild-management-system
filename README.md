# ⚔️ RPG Guild Management System — Java OOP Assessment

## Overview

In this assessment, you will design and implement a role-playing game (RPG) guild management system in Java.

The system stores guild members, manages inventories, tracks rankings, and processes matchmaking through queue-based systems.

The skeleton project is provided. Your task is to complete the implementation by following the TODO instructions in each file while applying Java OOP principles.

---

## Learning Outcomes

- OOP (Encapsulation, Inheritance, Abstract Classes)
- Greenfield Development
- Unit Testing
- System Design
- Collections (ArrayList, HashMap)
- Defensive Copying
- Queue Systems

---

## Time Limit

**3 Hours**

---

## Assessment Structure

| Component | Weight | Recommended Time |
|----------|--------|------------------|
| Implementation | 60% | 2 Hours |
| UML Class Diagram | 25% | 45 Minutes |
| Long Question | 15% | 15 Minutes |

---

## Scoring

Coding Score  = (tests passed / total tests) × 60%  
UML Score     = (marks earned / total UML marks) × 25%  
Long Q Score  = (marks earned / 10) × 15%  

Final Score   = Coding Score + UML Score + Long Q Score  

### Pass Requirement:
**60% or higher**

---

## Project Structure

rpg-guild-management-system/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── za/
    │           └── co/
    │               └── wethinkcode/
    │                   ├── Main.java
    │                   ├── model/
    │                   │   ├── GuildMember.java
    │                   │   ├── Item.java
    │                   │   ├── Quest.java
    │                   │   └── Match.java
    │                   └── service/
    │                       ├── GuildSystem.java
    │                       ├── PvPGuildSystem.java
    │                       └── PvEGuildSystem.java
    └── test/
        └── java/
            └── za/
                └── co/
                    └── wethinkcode/
                        ├── ItemTest.java
                        ├── GuildMemberTest.java
                        ├── QuestTest.java
                        ├── MatchTest.java
                        └── GuildSystemTest.java

---

## Implementation Instructions

Work through the provided TODO sections in the source files.

### Your responsibilities include:

- Declaring private fields
- Writing constructors
- Implementing getters/setters
- Overriding `toString()`
- Applying defensive copies
- Managing collections safely
- Completing abstract class functionality
- Implementing subclass behavior
- Passing all provided tests

---

## Testing Your Work

Run the following command regularly:

mvn clean compile test

Your goal is to achieve:

## ✅ 100% test pass rate

---

## UML Class Diagram

Create a UML diagram using **draw.io only**.

### Include:

- Class names
- Fields
- Methods
- Access modifiers
- Inheritance
- Associations

### Submission:
Export as:

uml.pdf

Place in project root.

---

## Long Question

Answer the provided system-design question in:

answers.txt

---

## Submission Notes

Before submission:

mvn clean compile

Your project **must compile successfully**.

---

# Good luck, have fun, and build your guild! ⚔️