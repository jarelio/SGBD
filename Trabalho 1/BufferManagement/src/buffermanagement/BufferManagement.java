package buffermanagement;

import java.util.Scanner;

/**
 *
 * @author jarelio
 */
public class BufferManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha2;
        int escolha;
        do{
            System.out.println("Qual política de substituição você deseja utilizar?\n 1. MRU\n 2. FIFO\n 3. LRU\n 4. CLOCK\n");
            escolha = scanner.nextInt();

            switch (escolha){
                case 1:
                    MRU mru_cache = new MRU();
                    do{
                        System.out.print("Que operação você deseja realizar? 1.Fetch 2.Evict 3.Display Cache 4.Display Stats : ");
                        escolha2 = scanner.nextInt();
                        switch(escolha2){
                            case 1:
                                System.out.print("Digite o valor da chave: ");
                                int chave = scanner.nextInt();
                                mru_cache.fetch(chave);
                                break;
                            case 2:
                                mru_cache.evict();
                                break;
                            case 3:
                                mru_cache.display_cache();
                                break;
                            case 4:
                                mru_cache.display_stats();
                                break;
                            default:
                                System.out.println("Opção errada");
                                break;
                        }
                    }while(escolha2==1 || escolha2==2 || escolha2==3 || escolha2==4);
                    break;
                case 2:
                    FIFO fifo_cache = new FIFO();
                    do{
                        System.out.print("Que operação você deseja realizar? 1.Fetch 2.Evict 3.Display Cache 4.Display Stats : ");
                        escolha2 = scanner.nextInt();
                        switch(escolha2){
                            case 1:
                                System.out.print("Digite o valor da chave: ");
                                int chave = scanner.nextInt();          
                                fifo_cache.fetch(chave);
                                break;
                            case 2:
                                fifo_cache.evict();
                                break;
                            case 3:
                                fifo_cache.display_cache();
                                break;
                            case 4:
                                fifo_cache.display_stats();
                                break;
                            default:
                                System.out.println("Opção errada");
                                break;
                        }
                    }while(escolha2==1 || escolha2==2 || escolha2==3 || escolha2==4);
                    break;
                case 3:
                    LRU lru_cache = new LRU();
                    do{
                        System.out.print("Que operação você deseja realizar? 1.Fetch 2.Evict 3.Display Cache 4.Display Stats : ");
                        escolha2 = scanner.nextInt();
                        switch(escolha2){
                            case 1:
                                System.out.print("Digite o valor da chave: ");
                                int chave = scanner.nextInt();        
                                lru_cache.fetch(chave);
                                break;
                            case 2:
                                lru_cache.evict();
                                break;
                            case 3:
                                lru_cache.display_cache();
                                break;
                            case 4:
                                lru_cache.display_stats();
                                break;
                            default:
                                System.out.println("Opção errada");
                                break;
                        }
                    }while(escolha2==1 || escolha2==2 || escolha2==3 || escolha2==4);
                    break;
                case 4:
                    CLOCK clock_cache = new CLOCK();
                    do{
                        System.out.print("Que operação você deseja realizar? 1.Fetch 2.Evict 3.Display Cache 4.Display Stats : ");
                        escolha2 = scanner.nextInt();
                        switch(escolha2){
                            case 1:
                                System.out.print("Digite o valor da chave: ");
                                int chave = scanner.nextInt();          
                                clock_cache.fetch(chave);
                                break;
                            case 2:
                                clock_cache.evict();
                                break;
                            case 3:
                                clock_cache.display_cache();
                                break;
                            case 4:
                                clock_cache.display_stats();
                                break;
                            default:
                                System.out.println("Opção errada");
                                break;
                        }
                    }while(escolha2==1 || escolha2==2 || escolha2==3 || escolha2==4);
                    break;
                default:
                    System.out.println("Opção errada");
                    break;

            }
        }while(escolha==1 || escolha==2 || escolha==3 || escolha==4);
    }
    
}
