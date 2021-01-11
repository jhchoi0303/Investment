from hashlib import sha1
from multiprocessing import Process, Queue




def work(id,start,end,result):

    f= open("rainbow"+str(id)+".txt",'w')
    entire = ""
    print("RAINBOW")
    for k in range (start,end):
        entire=str(k)+"salt_for_you"
        i=0
        while i<500:
            entire = sha1(entire.encode('utf-8'))
            entire=entire.hexdigest()
            i=i+1;

        f.write(str(k)+"IS"+entire+'\n');

    f.close()
    return 
          
if __name__ == "__main__":
    START, END = 10000000,100000000
    result = Queue()
    th1 = Process(target=work, args=(1, START, END//2, result))
    th2 = Process(target=work, args=(2, END//2, END, result))
    
    th1.start()
    th2.start()
    th1.join()
    th2.join()
