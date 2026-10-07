# theshamishop · Fashion Shop in Java

A desktop fashion shop app built with Java Swing.

## Features

- Welcome screen and category overview (tops, trousers, shoes, tracksuits, accessories)
- Product list per category with images and descriptions
- Search field
- Sort by price, ascending and descending
- Custom background images

## Structure

| File | Purpose |
|---|---|
| `willkommensframe.java` | Welcome screen |
| `kategorien.java` | Category selection |
| `theshamishop.java` | Main shop window: list, search, sorting, product details |
| `shamishop.java` | Shop logic and product data |
| `Hosen.java`, `oberteile.java`, `schuhe`, `tracksuits.java`, `accessoires.java` | Product categories |
| `produkt.java` | Draft of a product base class with subclasses (work in progress) |
| `*.uml` | UML class diagrams |

## Run

The compiled classes are included, so you can start the app directly from this folder:

```bash
java willkommensframe
```

The image files need to be in the same folder as the program.

## Built with

Java, Swing
