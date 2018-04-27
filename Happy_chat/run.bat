@echo off

rem The running environment of test.jar is jdk1.8 at least.

if "%OS%" == "Windows_NT" setlocal
rem ---------------------------------------------------------------------------
rem Start script for the xxx client
rem ---------------------------------------------------------------------------

set "CURRENT_DIR=%cd%"
set "JRE_HOME=%CURRENT_DIR%"
if exist "%JRE_HOME%\jre\bin\java.exe" goto okHome
cd ..
set "JRE_HOME=%cd%"
cd "%CURRENT_DIR%"
:okHome

set "EXECUTABLE=%JRE_HOME%\jre\bin\java.exe"

rem Check that target executable exists
if exist "%EXECUTABLE%" goto okExec
echo Cannot find "%EXECUTABLE%"
echo This file is needed to run this program
goto end

:okExec

rem Get remaining unshifted command line arguments and save them in the
set CMD_LINE_ARGS=
:setArgs
if ""%1""=="""" goto doneSetArgs
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setArgs
:doneSetArgs

cd jre\bin
java -jar %JRE_HOME%\Happy_Chat.jar %CMD_LINE_ARGS%

:end