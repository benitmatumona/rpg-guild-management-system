⚔️ RPG Guild Management System — Java OOP Assessment

Overview
In this assessment you will design and implement a role-playing game (RPG) Guild Management System in Java. The system simulates a guild where players manage inventories, equip items, and participate in match-based encounters processed through a queue system.

The skeleton project is provided. Your task is to implement the classes described in the steps below, following the principles of Encapsulation, Inheritance, and Abstraction as taught in the Java-OOP modules.

Learning Outcomes
- Object-Oriented Programming (Encapsulation, Inheritance, Abstraction)
- Greenfield Development
- Unit Testing with JUnit
- System Design
- Collections (ArrayList, HashMap)
- Defensive Copying
- Queue-Based Processing

Time Limit
3 hours

Assessment Structure
| Component       | Weight | Recommended Time |
|----------------|--------|------------------|
| Implementation | 100%   | 3 hours          |

Scoring
Coding Score = (tests passed / total tests) × 100%

Final Score = Coding Score

To pass, your Final Score must be 60% or higher.

Project Structure
rpg-guild-management-system/
│
├── pom.xml
│
└── src/
    ├── main/
    │   └── java/
    │       └── za/
    │           └── co/
    │               └── wethinkcode/
    │                   │
    │                   ├── Main.java
    │                   │
    │                   ├── model/
    │                   │   ├── Item.java
    │                   │   ├── Weapon.java
    │                   │   ├── Armor.java
    │                   │   ├── Inventory.java
    │                   │   ├── Player.java
    │                   │   └── Match.java
    │                   │
    │                   └── service/
    │                       ├── GuildSystem.java
    │                       ├── PvPGuildSystem.java
    │                       └── PvEGuildSystem.java
    │
    └── test/
        └── java/
            └── za/
                └── co/
                    └── wethinkcode/
                        ├── ItemTest.java
                        ├── InventoryTest.java
                        ├── PlayerTest.java
                        └── GuildSystemTest.java

As you implement each step, run the full test suite:

mvn clean compile test

Your goal is to reach 100% of tests passing before submission.

Implementation Steps
Work through the steps in order — later classes depend on earlier ones.

Step 1 — Implement Item
File: src/main/java/za/co/wethinkcode/model/Item.java

The Item class is the base class for all items in the system.

| Field | Type | Description |
|------|------|-------------|
| id | int | Unique identifier (private) |
| name | String | Item name (private) |
| value | int | Item value (private) |

Constructor
| Signature |
|----------|
| Item(int id, String name, int value) |

Methods
| Method | Description |
|--------|-------------|
| getId() | Returns item id |
| getName() | Returns item name |
| getValue() | Returns item value |
| updateValue(int newValue) | Updates value (throws IllegalArgumentException if negative) |
| itemType() | Abstract method returning item type |
| toString() | Returns [Type] Name (ID: X, Value: Y) |

Step 2 — Implement Weapon
File: src/main/java/za/co/wethinkcode/model/Weapon.java

Weapon is a type of Item with damage capability.

| Field | Type | Description |
|------|------|-------------|
| damage | int | Weapon damage |

Constructor
| Signature |
|----------|
| Weapon(int id, String name, int value, int damage) |

Methods
| Method | Description |
|--------|-------------|
| getDamage() | Returns damage |
| upgradeDamage(int bonusDamage) | Increases damage (throws error if negative) |
| itemType() | Returns "Weapon" |
| toString() | [Weapon] Name (ID: X, Value: Y, Damage: Z) |

Step 3 — Implement Armor
File: src/main/java/za/co/wethinkcode/model/Armor.java

Armor provides defensive stats.

| Field | Type | Description |
|------|------|-------------|
| defense | int | Defense value |

Constructor
| Signature |
|----------|
| Armor(int id, String name, int value, int defense) |

Methods
| Method | Description |
|--------|-------------|
| getDefense() | Returns defense |
| upgradeDefense(int bonusDefense) | Increases defense (throws error if negative) |
| itemType() | Returns "Armor" |
| toString() | [Armor] Name (ID: X, Value: Y, Defense: Z) |

Step 4 — Implement Inventory
File: src/main/java/za/co/wethinkcode/model/Inventory.java

The Inventory stores all items owned by a player.

| Field | Type |
|------|------|
| items | List<Item> |

Methods
| Method | Description |
|--------|-------------|
| addItem(Item) | Adds item |
| removeItemById(int) | Removes item and returns true/false |
| getItemById(int) | Returns item or null |
| getItems() | Returns defensive copy |
| getTotalValue() | Sum of item values |
| getTotalItems() | Number of items |
| containsItem(String) | Checks if item exists |
| toString() | Returns formatted list |

Step 5 — Implement Player
File: src/main/java/za/co/wethinkcode/model/Player.java

The Player represents a guild member.

| Field | Type |
|------|------|
| id | int |
| name | String |
| level | int |
| xp | int |
| gold | int |
| rank | PlayerRank |
| inventory | Inventory |
| equippedWeapon | Weapon |
| equippedArmor | Armor |

Constructor
| Signature |
|----------|
| Player(int id, String name) |

Initial Values
| Field | Value |
|------|------|
| level | 1 |
| xp | 0 |
| gold | 0 |
| rank | BRONZE |

Methods
| Method | Description |
|--------|-------------|
| addExperience(int) | Adds XP |
| levelUp() | Increases level |
| addGold(int) | Adds gold |
| spendGold(int) | Deducts gold (throws error if insufficient) |
| equipWeapon(Weapon) | Equips weapon |
| equipArmor(Armor) | Equips armor |
| inventory() | Returns inventory |
| updateRank(PlayerRank) | Updates rank |
| toString() | Returns player summary |

Step 6 — Implement GuildSystem
File: src/main/java/za/co/wethinkcode/service/GuildSystem.java

The GuildSystem manages members and match processing.

| Field | Type |
|------|------|
| guildName | String |
| members | List<GuildMember> |
| matchQueue | List<Match> |
| memberCounter | int |

Methods
| Method | Description |
|--------|-------------|
| addMember(GuildMember) | Adds member |
| removeMemberById(int) | Removes member |
| getMemberById(int) | Returns member |
| getAllMembers() | Returns unmodifiable list |
| createMatch(int, int) | Creates match |
| processNextMatch() | Processes next pending match |
| matchQueue() | Returns queue |
| guildName() | Returns name |

Abstract Method
| Method |
|--------|
| resolveMatch(Match) |

Step 7 — Implement PvP System
File: PvPGuildSystem.java

Rules:
- Higher level wins
- If levels are equal → member1 wins
- Print:
PvP Match resolved: Winner is Member X

Step 8 — Implement PvE System
File: PvEGuildSystem.java

Rules:
- Player vs enemy logic
- Higher level wins
- Print:
PvE Match resolved: Winner is Member X

NOTE:
Before submission ensure project compiles:

mvn clean compile test

Good luck — build your guild ⚔️