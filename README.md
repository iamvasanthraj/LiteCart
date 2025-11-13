# LiteCart – Java Servlet & JSP Mini E-Commerce Application

LiteCart is a lightweight e-commerce web application built using Java Servlets, JSP, JDBC, and Tomcat.

It includes:
- User signup and login
- Product listing page
- Add-to-cart functionality
- View and clear cart
- Secure session-based logout

---

## Features

### Authentication
- Users can sign up and log in.
- Session-based authentication.
- Cache disabled to prevent accessing pages after logout.

### Product Management
- Products are retrieved from the database.
- Displayed in a clean table layout.
- Each product includes an "Add to Cart" button.

### Shopping Cart
- Cart stored inside the user session.
- Multiple items can be added.
- Cart can be viewed or cleared anytime.

### Security
- Shop page requires login.
- Unauthorized users are redirected to login page.

---

## Technologies Used

| Layer      | Technology            |
|-----------|------------------------|
| Backend   | Java Servlets (Jakarta EE) |
| Frontend  | JSP, HTML, CSS         |
| Database  | MySQL                  |
| Server    | Apache Tomcat 10+      |
| IDE       | Eclipse                |

---

## How LiteCart Works

### 1. Login Flow
- User submits the login form to `/Login`.
- The `Logincheck` DAO validates credentials.
- When valid, a session is created and the user is forwarded to the shop page.
- Invalid users are redirected to signup.

### 2. Adding Items to Cart
- "Add" button in `shop.jsp` posts to `/cart`.
- The servlet creates/updates a cart stored in the session.
- Items appear in `cart.jsp`.

### 3. Clearing the Cart
- `/Clear` servlet removes the cart attribute from session.
- User is redirected back to `/shop`.

### 4. Loading Products
- `/shop` servlet fetches products using `StoreDao`.
- Products are passed via `request.setAttribute("products")`.
- Displayed in `shop.jsp`.

---

## Setup Instructions

### 1. Import Project
- Open Eclipse → File → Import → Dynamic Web Project.

### 2. Configure Tomcat
- Add Apache Tomcat 10 or 11 to Eclipse.

