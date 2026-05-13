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
## Project Structure

```text
rpg-guild-management-system/
├── pom.xml
│
└── src/
    ├── main/
    │   └── java/
    │       └── za/
    │           └── co/
    │               └── wethinkcode/
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
```
As you implement each step, run the full test suite:

mvn clean compile test

Your goal is to reach 100% of tests passing before submission.

Implementation Steps
Work through the steps in order — later classes depend on earlier ones.

Step 1 — Implement Item
File: src/main/java/za/co/wethinkcode/model/Item.java

The Item class is the base class for all items in the system.

| Field | Type | Access | Description |
|------|------|--------|-------------|
| id | int | private | Unique identifier for the item |
| name | String | private | Name of the item |
| value | int | private | Monetary value of the item |

Constructor
| Signature | Access |
|----------|--------|
| Item(int id, String name, int value) | public |

Methods
| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getId() | int | public | Returns item id |
| getName() | String | public | Returns item name |
| getValue() | int | public | Returns item value |
| updateValue(int newValue) | void | public | Updates value (throws IllegalArgumentException if negative) |
| itemType() | String | public abstract | Returns item type |
| toString() | String | public | Returns [Type] Name (ID: X, Value: Y) |

Step 2 — Implement Weapon
File: src/main/java/za/co/wethinkcode/model/Weapon.java

Weapon is a specialized item with damage.

| Field | Type | Access | Description |
|------|------|--------|-------------|
| damage | int | private | Weapon damage |

Constructor
| Signature | Access |
|----------|--------|
| Weapon(int id, String name, int value, int damage) | public |

Methods
| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getDamage() | int | public | Returns damage |
| upgradeDamage(int bonusDamage) | void | public | Increases damage (throws IllegalArgumentException if negative) |
| itemType() | String | public | Returns "Weapon" |
| toString() | String | public | Returns [Weapon] Name (ID: X, Value: Y, Damage: Z) |

Step 3 — Implement Armor
File: src/main/java/za/co/wethinkcode/model/Armor.java

Armor is a defensive item.

| Field | Type | Access | Description |
|------|------|--------|-------------|
| defense | int | private | Armor defense value |

Constructor
| Signature | Access |
|----------|--------|
| Armor(int id, String name, int value, int defense) | public |

Methods
| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getDefense() | int | public | Returns defense |
| upgradeDefense(int bonusDefense) | void | public | Increases defense (throws IllegalArgumentException if negative) |
| itemType() | String | public | Returns "Armor" |
| toString() | String | public | Returns [Armor] Name (ID: X, Value: Y, Defense: Z) |

Step 4 — Implement Inventory
File: src/main/java/za/co/wethinkcode/model/Inventory.java

The Inventory stores and manages player items safely.

| Field | Type | Access | Description |
|------|------|--------|-------------|
| items | List<Item> | private | List of items |

Constructor
| Signature | Access |
|----------|--------|
| Inventory() | public |

Methods
| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| addItem(Item) | void | public | Adds item |
| removeItemById(int) | boolean | public | Removes item by id |
| getItemById(int) | Item | public | Returns item or null |
| getItems() | List<Item> | public | Returns defensive copy |
| getTotalValue() | int | public | Sum of item values |
| getTotalItems() | int | public | Number of items |
| containsItem(String) | boolean | public | Checks if item exists |
| toString() | String | public | Returns formatted inventory |

Step 5 — Implement Player
File: src/main/java/za/co/wethinkcode/model/Player.java

The Player represents a guild member.

| Field | Type | Access | Description |
|------|------|--------|-------------|
| id | int | private | Player ID |
| name | String | private | Player name |
| level | int | private | Player level |
| xp | int | private | Experience points |
| gold | int | private | Currency |
| rank | PlayerRank | private | Player rank |
| inventory | Inventory | private | Player inventory |
| equippedWeapon | Weapon | private | Equipped weapon |
| equippedArmor | Armor | private | Equipped armor |

Constructor
| Signature | Access |
|----------|--------|
| Player(int id, String name) | public |

Initial Values
| Field | Value |
|------|------|
| level | 1 |
| xp | 0 |
| gold | 0 |
| rank | BRONZE |

Methods
| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| addExperience(int) | void | public | Adds XP |
| levelUp() | void | public | Increases level |
| addGold(int) | void | public | Adds gold |
| spendGold(int) | void | public | Deducts gold (throws error if insufficient) |
| equipWeapon(Weapon) | void | public | Equip weapon |
| equipArmor(Armor) | void | public | Equip armor |
| inventory() | Inventory | public | Returns inventory |
| updateRank(PlayerRank) | void | public | Updates rank |
| toString() | String | public | Player summary |

Step 6 — Implement GuildSystem
File: src/main/java/za/co/wethinkcode/service/GuildSystem.java

The GuildSystem manages members and match processing.

| Field | Type | Access | Description |
|------|------|--------|-------------|
| guildName | String | private | Guild name |
| members | List<GuildMember> | private | Members list |
| matchQueue | List<Match> | private | Match queue |
| memberCounter | int | private | Counter |

Constructor
| Signature | Access |
|----------|--------|
| GuildSystem(String guildName) | public |

Methods
| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| addMember(GuildMember) | void | public | Add member |
| removeMemberById(int) | boolean | public | Remove member |
| getMemberById(int) | GuildMember | public | Get member |
| getAllMembers() | List<GuildMember> | public | Unmodifiable list |
| createMatch(int,int) | Match | public | Create match |
| processNextMatch() | Match | public | Process next match |
| matchQueue() | List<Match> | public | Return queue |
| guildName() | String | public | Return name |

Abstract Method
| Method | Access |
|--------|--------|
| resolveMatch(Match) | protected abstract |

Step 7 — Implement PvP System
File: PvPGuildSystem.java

Rules:
- Higher level wins
- If equal level → member1 wins
- Output:
PvP Match resolved: Winner is Member X

Step 8 — Implement PvE System
File: PvEGuildSystem.java

Rules:
- Player vs enemy logic
- Higher level wins
- Output:
PvE Match resolved: Winner is Member X

Before submission ensure:

mvn clean compile test

Good luck — build your guild ⚔️