#include <stdio.h>
// โดน Photo paper ไปแล้วจุกเลยตรับ
#define MAX_GOODS 100

struct myGoodsRec {
    int ID;
    char name[20];
    char type;
    float cost;
    float tax;
    float netPrice;
};
typedef struct myGoodsRec Goods;
Goods myGoods[100];

int main() {
    int i = 0;
    FILE *goodsf, *reportf;

    if ((goodsf = fopen("goods.txt", "r")) == NULL) return 1;
    if ((reportf = fopen("Report6809617415.txt", "w")) == NULL) {
        fclose(goodsf);
        return 1;
    }

    fprintf(reportf, "ID   Name                Type        Cost      Tax   NetPrice\n");

    while (i < MAX_GOODS && fscanf(goodsf, "%d %s %c %f", &myGoods[i].ID, myGoods[i].name, &myGoods[i].type, &myGoods[i].cost) == 4) {
        
        myGoods[i].tax = (myGoods[i].type == 'A')? myGoods[i].cost * 0.10:
                        (myGoods[i].type == 'B')? myGoods[i].cost * 0.15:
                        (myGoods[i].type == 'C')? myGoods[i].cost * 0.20:
                        myGoods[i].cost * 0.40;

        myGoods[i].netPrice = myGoods[i].cost + myGoods[i].tax;

        fprintf(reportf, "%-4d %-20s %-5c %10.2f %8.2f %10.2f\n",
            myGoods[i].ID,
            myGoods[i].name,
            myGoods[i].type,
            myGoods[i].cost,
            myGoods[i].tax,
            myGoods[i].netPrice
        );
        i++;
    }

    fclose(goodsf);
    fclose(reportf);
    return 0;
}