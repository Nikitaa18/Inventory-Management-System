@echo off
cd /d "%~dp0"
javac -d bin src\app\Main.java src\model\Product.java src\service\InventoryService.java src\service\FileInventoryService.java src\util\ValidationUtil.java
java -cp bin app.Main
pause
