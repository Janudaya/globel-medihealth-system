# GlobeMed HMS — Java Swing + Design Patterns Sample Project

This sample project demonstrates **five** classic design patterns inside a tiny Healthcare Management System UI:

- **Command** — appointment booking/cancel actions
- **Chain of Responsibility** — insurance claim processing pipeline
- **Composite** — patient record made of notes/prescriptions
- **Visitor** — report generation (Text and HTML) over domain objects
- **Decorator** — secure persistence (encryption + logging) for patient records

> Built for education. Use as a reference and customize to your own assignment's needs.

## How to run

### Option 1: Using `javac` (no build tools)

```bash
# from project root
cd src
javac $(find . -name "*.java")
# run
java com.globemed.hms.Main
```

### Option 2: Using VS Code or any IDE
- Open the `src` folder as a Java project.
- Run `Main.java`

No external libraries are required (pure Java + Swing).

## Project structure
- `com.globemed.hms.ui.*` — Swing UI (tabs)
- `com.globemed.hms.command.*` — Command pattern for appointments
- `com.globemed.hms.cor.*` — Chain of Responsibility for claims
- `com.globemed.hms.composite.*` — Composite patient records
- `com.globemed.hms.visitor.*` — Visitor for reports
- `com.globemed.hms.decorator.*` — Decorator for secure storage
- `com.globemed.hms.model.*` — Simple data classes
- `com.globemed.hms.security.*` — Minimal role-based access check (decorator)

## Notes
- Encryption is a simple XOR for demonstration (do **not** use in production).
- Data is in-memory; "storage" writes to a temp file under `./data/patients.dat` via the DataSource interface.
