#!/bin/bash
#Run the front-end instances
for i in *in.txt; do
	echo Running Front End Instance \"${i%_*}\"
	./front-end ./current_accounts.txt ./${i%_*}_transact.txt
done

#Concatenate transaction output
cat *_transact.txt > master_transact.txt

#Run the back-end
java -jar backend.jar master_bank.txt master_transact.txt bank.txt master_bank.txt
