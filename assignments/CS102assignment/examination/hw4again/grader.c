#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int ID;
    char name[20]; 
    char type;
    float cost;
    float tax;
    float netPrice;
} myGoodsRec;

void findTax(myGoodsRec *goods) {
    char t;
    float multi = ((t = goods->type) == 'D')?40:(t=='C')?20:(t=='B')?15:10;
    goods->tax = goods->cost * multi / 100;
    goods->netPrice = goods->cost + goods->tax;
}

int main(void) {
    size_t size = 1, length = -1;
    myGoodsRec *records = (myGoodsRec*)calloc(size, sizeof(myGoodsRec)), *tmp;
    FILE *goodsFile = fopen("goods.txt", "r");
    FILE *recordFile = fopen("record.txt", "w");
    
    while (!feof(goodsFile)) {
        length++;
        if (length + 1 == size) {
            size *= 2;
            tmp = realloc(records, sizeof(myGoodsRec) * size);
            records = tmp;
        }
        fscanf("%d %s %c %f", &records[length].ID, records[length].name, &records[length].type, &records[length].cost);
        findTax(&records[length]);
        fprintf(recordFile, "%4d %15s %c\t %10.2f %8.2f %10.2f\n", records[length].ID, records[length].name, records[length].type, records[length].cost, records[length].tax, records[length].netPrice);
    }

    free(records);

    fclose(goodsFile);
    fclose(recordFile);

    return 0;
}