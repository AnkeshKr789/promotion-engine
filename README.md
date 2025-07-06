# 👒 Promotion Engine - Spring Boot

This project implements a **Promotion Engine** for a retail checkout system using Spring Boot. The goal is to calculate the final total price of items in a shopping cart by applying various promotions (e.g., "3 A's for 130", "C + D for 30").

---

## 🧩 Problem Statement

> Implement a simple promotion engine for a checkout process.
> The cart contains a list of SKU IDs (A, B, C, D) over which the promotion engine should run.

### 💰 SKU Prices:

* A: ₹50
* B: ₹30
* C: ₹20
* D: ₹15

### 🏷️ Active Promotions:

* **3 of A’s** for ₹130
* **2 of B’s** for ₹45
* **C + D combo** for ₹30

### 🔀 Scenarios

| Cart Items  | Expected Total |
| ----------- | -------------- |
| 1A 1B 1C    | ₹100           |
| 5A 5B 1C    | ₹370           |
| 3A 5B 1C 1D | ₹280           |

> The system should be modular to allow adding more promotion types (e.g., percentage-based or date-based) later.

---

## ✅ Requirements

* Java 21
* Maven
* Spring Boot 3+
* Lombok (for model simplification)
* Postman or curl (for testing)

---

## 📂 Project Structure

```
promotion-engine/
├── controller/               # REST API
├── model/                   # SKU, CartItem, CartRequest, CartResponse
├── promotion/               # Promotion logic (interface + implementations)
├── service/                 # PromotionEngineService for applying logic
├── config/                  # SkuConfig reads SKU prices from application.yml
├── resources/
│   └── application.yml      # SKU prices defined here
└── test/                    # Unit tests for service and promotions
```

---

## ⚙️ How to Run the Project

### 🔧 1. Clone the Repository

```bash
git clone https://github.com/AnkeshKr789/promotion-engine.git
```

### 🔧 2. Build & Run with Maven

```bash
mvn spring-boot:run
```

OR in IntelliJ:
Right-click on `PromotionEngineApplication.java` → Run

---

## 📬 API Usage

### Endpoint: `POST /checkout`

**Request:**

```json
{
  "items": [
    { "skuId": "A", "quantity": 3 },
    { "skuId": "B", "quantity": 5 },
    { "skuId": "C", "quantity": 1 },
    { "skuId": "D", "quantity": 1 }
  ]
}
```

**Response:**

```json
{
  "total": 280
}
```

---

## 🧪 How to Run Tests

Run all unit tests:

```bash
mvn test
```

Tests cover:

* Scenario A, B, C
* Invalid input (null/empty)
* Promotion edge cases
* Bulk & Combo promotions

---
