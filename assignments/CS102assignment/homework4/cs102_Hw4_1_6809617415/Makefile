OBJDIR = obj
OBJ = $(OBJDIR)/grader.o $(OBJDIR)/get_n_terms.o
APP = grade
CC = gcc-15
FLAGS = -std=c99

$(APP): $(OBJ)
	$(CC) $(FLAGS) -o $(APP) $(OBJ)

$(OBJDIR)/grader.o: grader.c get_n_terms.h | $(OBJDIR)
	$(CC) $(FLAGS) -c grader.c -o $(OBJDIR)/grader.o

$(OBJDIR)/get_n_terms.o: get_n_terms.c get_n_terms.h | $(OBJDIR)
	$(CC) $(FLAGS) -c get_n_terms.c -o $(OBJDIR)/get_n_terms.o

$(OBJDIR):
	mkdir -p $(OBJDIR)

clean:
	rm -f $(APP)
