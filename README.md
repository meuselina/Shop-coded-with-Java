# theshamishop · Fashion Shop in Java

A desktop fashion shop app built with Java Swing. I originally wrote it for a computer science course at school and later refactored it and translated it into English.

![Shop window](screenshot.jpg)

## Features

- Welcome screen and category overview (tops, pants, shoes, tracksuits, accessories)
- Product list per category with images and descriptions
- Search by product type, color or material (press Enter or click search)
- Sort by price, ascending and descending
- Product details with a matching picture for every category
- Custom background images

## Structure

| File | Purpose |
|---|---|
| `WelcomeFrame.java` | Welcome screen and entry point |
| `CategoryFrame.java` | Category selection |
| `ShopFrame.java` | Main shop window: list, search, sorting, product details |
| `ShopData.java` | Product data, search and price sorting |
| `Product.java` | Abstract base class with all shared product attributes |
| `Tops.java`, `Pants.java`, `Shoes.java`, `Tracksuits.java`, `Accessories.java` | Product categories, each extends `Product` (inheritance) |

## Run

```bash
javac -encoding UTF-8 *.java
java WelcomeFrame
```

The image files need to be in the same folder as the program.

## Built with

Java, Swing
