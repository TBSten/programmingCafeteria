@echo off
echo ��com�փR�s�[���܂�
xcopy C:\Users\Wing_E_Valley\Documents\�v���O���~���O\java\eclipceWorkSpace\�v���O���~���O�H��\src D:\�h�L�������g\[project]�v���O���~���O�H��\_forgithub /D /S /R /Y /I /K

echo ��git add ���Ăяo���܂�
git add *

echo ��git commit�@���Ăяo���܂�
git commit -m "add new file"

echo ��git status ���Ăяo���܂�
git status

echo ��git remote ���Ăяo���܂�
git remote add origin https://github.com/TBSten/programmingCafeteria.git

echo ��git push ���Ăяo���܂�
git push origin master

pause


