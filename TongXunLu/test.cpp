#include <stdio.h>

int main()
{
	char name1[20]={"ֻû"};
	char name2[20]={"ּ״"};
	char name3[20]={"ּ¸"};
	char name4[20]={"ְּ"};
	char name5[20]={"ּÛ"};
	int i;
	for (i=0;i<8;i++)
		printf("%d ",name1[i]);
	printf("\n");
	for (i=0;i<8;i++)
		printf("%d ",name2[i]);
	printf("\n");
	for (i=0;i<8;i++)
		printf("%d ",name3[i]);
	printf("\n");
	for (i=0;i<8;i++)
		printf("%d ",name4[i]);
	printf("\n");
	for (i=0;i<8;i++)
		printf("%d ",name5[i]);
	printf("\n");
	return 0;
}