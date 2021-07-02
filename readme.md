## Page Printer

This project take screenshots of web pages using selenium and chrome driver.

### Dependencies

- Java ^11
- Gradle ^6.8
- Chrome driver

### Setup

1. Execute the commands bellow:

```bash
git clone https://github.com/kaio-giovanni/page-printer.git
cd page-printer
gradle clean build
```

2. Install Chrome driver

   2.1 Using docker

   ```bash

   docker pull selenium/standalone-chrome
   docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome
   ```

   2.2 Installing on ubuntu

   ```bash

   RUN apt-get install chromium-driver -y
   ```

3. Add path of chrome driver into .env file

```
CHROME_DRIVER_URL=http://localhost:4444/wd/hub
```

### Run

To run project, execute the command bellow:

```bash

gradle run --args="-p [PAGE_PRINTER]"
```

### Author

| ![user](https://avatars1.githubusercontent.com/u/64810260?v=4&s=150)                    |
| --------------------------------------------------------------------------------------- |
| <p align="center"> <a href="https://github.com/kaio-giovanni"> @kaio-giovanni </a> </p> |
