@ECHO OFF
echo this is a test.bat file used to test "if time is before midi,then the errorlevel will be set to 01,else it will be 02."
set HH=%TIME: =0%
set HH=%HH:~0,2%
echo hour is %HH%

IF %HH% LEQ 12 GOTO before
IF %HH% GTR 12 GOTO after

:before
echo now it is before midi
set errorlevel=01
echo errorlevel is %errorlevel%
exit 01

:after
echo now it is after midi
set errorlevel=02
echo errorlevel is %errorlevel%
exit 02