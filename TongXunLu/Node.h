#ifndef NODE_H
#define NODE_H

#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fstream>
using namespace std;

#define OK 1
#define NO 0
#define error -1

//�ڵ�Ԫ��
struct Elem
{
	char name[30];
	char word;
	char phone1[20];
	char phone2[20];
	char qq[15];
	Elem * Next;
	Elem(){Next=NULL;}
};

//��ϵ��ͷ�ڵ�
struct ElemList
{
	int num;
	Elem * head;
	ElemList()
	{
		num=0;
		head = NULL;
	}
};

#endif