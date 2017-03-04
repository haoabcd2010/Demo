#include "Node.h"
#include "Get_Head_Word.h"

/*
//�½���ϵ������
//ɾ����ϵ������
//�� L ����β����һ�� P �ڵ�
//�� L �����в���һ�� P �ڵ�
//�� L ������ɾ��һ�� P �ڵ�
//��ʾ��������
*/



int DeleteElemList(ElemList & L);//����

//�½���ϵ������
int CreatElemList(ElemList & L)
{
	if (L.num!=0) DeleteElemList(L);
	return OK;
}

//ɾ����ϵ������
int DeleteElemList(ElemList & L)
{
	if (L.head==NULL) return OK;
	Elem * p=L.head;
	Elem * k=p->Next;
	while(k)
	{
		delete(p);
		p=k;
		k=k->Next;
	}
	delete(p);
	L.head=NULL;
	L.num=0;
	return OK;
}

//�� L ����β����һ�� P �ڵ�
int AddElem(ElemList & L,Elem * p)
{
	Elem * t = new (Elem);
	* t = * p;//����
	Elem * cur = L.head;
	if (cur==NULL)
	{
		L.num=1;
		L.head=t;
		return OK;
	}
	while (cur->Next)
		cur = cur->Next;
	cur->Next=t;
	L.num++;
	return OK;
}

//�� L �����в���һ���ڵ�
//�ҵ����ص�ַ��û�ҵ����� NULL
//k 1 ������ 2 �ֻ��� 3 ������ 4 QQ��
Elem * FindElem(ElemList & L,char p[],int k)
{
	Elem * cur = L.head;
	while (cur)
	{
		if (k==1)
		{
			if (!strcmp(p,cur->name))
			return cur;
		}
		else if (k==2)
		{
			if (!strcmp(p,cur->phone1)||!strcmp(p,cur->phone2))
			return cur;
		}
		else if (k==4)
		{
			if (!strcmp(p,cur->qq))
			return cur;
		}
		cur = cur->Next;
	}
	return NULL;
}

//�� L ������ɾ��һ�� P �ڵ�
int DeleteElem(ElemList & L,Elem * pos)
{
	if (pos==NULL) return NO;
	if (pos==L.head)
	{
		L.head=L.head->Next;
		L.num--;
		delete(pos);
		return OK;
	}
	Elem * cur = L.head;
	Elem * nex = cur->Next;
	while (nex)
	{
		if (nex==pos) break;
		cur=nex;
		nex=nex->Next;
	}
	cur->Next = nex->Next;
	delete(nex);
	L.num--;
	return OK;
}

//��ʾ��������
int DisplayElemList(ElemList & L)
{
	if (L.head==NULL) 
	{
		return NO;
	}
	Elem * cur = L.head;
	cout<<"-------------------------------------------------------------"<<endl;
	printf("%-12s %-16s %-16s %-16s\n","����","�ֻ���1","�ֻ���2","QQ");
	cout<<"-------------------------------------------------------------"<<endl;
	char s;
	while (cur)
	{
		if (cur==L.head)
		{
			s=cur->word;
			printf("%c\n",s);
		}
		else
		{
			char now=cur->word;
			if (now!=s)
			{
				s=now;
				printf("%c\n",s);
			}
		}
		printf("%-12s %-16s %-16s %-16s\n",cur->name,cur->phone1,cur->phone2,cur->qq);
		cur=cur->Next;
	}
	cout<<"-------------------------------------------------------------"<<endl;
	cout<<"�� "<<L.num<<" ����ϵ��"<<endl;
	return OK;
}

//����������
int SortElemList(ElemList &L)
{
	if (L.head==NULL) return NO;

	Elem * pos = L.head;
	Elem * cur,* next;

	for (int i=0;i<L.num-1;i++)
	{
		cur = L.head;
		next=cur->Next;
		for (int j=0;j<L.num-1-i;j++)
		{
			if(strcmp(cur->name,next->name)>0)
			{
				char str[20];
				strcpy(str,cur->name);
				strcpy(cur->name,next->name);
				strcpy(next->name,str);

				int temp=cur->word;
				cur->word=next->word;
				next->word=temp;

				strcpy(str,cur->phone1);
				strcpy(cur->phone1,next->phone1);
				strcpy(next->phone1,str);

				strcpy(str,cur->phone2);
				strcpy(cur->phone2,next->phone2);
				strcpy(next->phone2,str);

				strcpy(str,cur->qq);
				strcpy(cur->qq,next->qq);
				strcpy(next->qq,str);
			}
			cur=next;
			next=next->Next;
		}	
	}
	return OK;
}