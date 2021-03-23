@echo off
echo ●comへコピーします
xcopy C:\Users\Wing_E_Valley\Documents\プログラミング\java\eclipceWorkSpace\プログラミング食堂\src D:\ドキュメント\[project]プログラミング食堂\_forgithub /D /S /R /Y /I /K

echo ●git add を呼び出します
git add *

echo ●git commit　を呼び出します
git commit -m "add new file"

echo ●git status を呼び出します
git status

echo ●git remote を呼び出します
git remote add origin https://github.com/TBSten/programmingCafeteria.git

echo ●git push を呼び出します
git push origin master

pause


