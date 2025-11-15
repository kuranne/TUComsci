CC = gcc-15
FLAGS = -std=c99
APP = grader
OBJDIR = obj
OBJ = $(OBJDIR)/grader.o $(OBJDIR)/stats.o $(OBJDIR)/bubbleSort.o
FILESNAME = grader stats bubbleSort
HEADER = stats.h 

$(APP) : $(OBJ)
	$(CC) $(FLAG) $(OBJ) -o $(APP)

$(OBJDIR)/grader.o : grader.c $(HEADER)
	$(CC) $(FLAGS) -c grader.c -o $(OBJDIR)/grader.o

$(OBJDIR)/stats.o : stats.c $(HEADER)
	$(CC) $(FLAGS) -c stats.c -o $(OBJDIR)/stats.o

$(OBJDIR)/bubbleSort.o : bubbleSort.c $(HEADER)
	$(CC) $(FLAGS) -c bubbleSort.c -o $(OBJDIR)/bubbleSort.o

clean: 
	rm -rf $(OBJ) $(APP)