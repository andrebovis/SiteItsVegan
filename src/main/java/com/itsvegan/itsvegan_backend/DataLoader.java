package com.itsvegan.itsvegan_backend;

import com.itsvegan.itsvegan_backend.model.Produto;
import com.itsvegan.itsvegan_backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public DataLoader(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        produtoRepository.deleteAll();

        double desconto = 0.23;

        // Combos
        Produto p1 = new Produto("Combos", "Combo Palermo, Fritas e Bebida", "Sanduíche com 3 pedaços de linguiça plant based, vinagrete com limão siciliano, maionese de castanhas e chimichuri, fritas e bebida a sua escolha.", 43.70);
        double preco1 = calcularPrecoFinal(p1.getPreco(), desconto);
        p1.setPreco(preco1);
        produtoRepository.save(p1);

        Produto p2 = new Produto("Combos", "Combo Romerberg, Fritas e Bebida", "Hotdog com linguiça (plant based), chucrute temperado e mostarda dijon, fritas e bebida a sua escolha.", 45.53);
        double preco2 = calcularPrecoFinal(p2.getPreco(), desconto);
        p2.setPreco(preco2);
        produtoRepository.save(p2);
        
        Produto p3 = new Produto("Combos", "Combo Brooklyn (Meat Salad Burger )+ Fritas + Bebida", "Nosso tradicional Brooklyn com delicioso pão de hambúrguer com gergelim (opção sem glúten ), incrivel burguer de carne plant based (100g e base de ervilha- pode conter gluten) e o chocante queijo de castanhas com cebola, picles, tomate fresquinho e um toque de ketchup e mostarda pra finalizar. Acompanha batata frita feita na casa (opçoẽs de troca com adicional) e a um refri ou agua, tambem com trocas opcionais.Serve 1 pessoa", 63.90);
        double preco3 = calcularPrecoFinal(p3.getPreco(), desconto);
        p3.setPreco(preco3);
        produtoRepository.save(p3);

        Produto p4 = new Produto("Combos", "Combo Buckhead (Chicken Burger)+ Fritas+ Bebida", "Tradicional Buckhead - delicioso burger de frango Plant Based ( base de ervilha) , pão de hambúrguer com gergelim ( opção sem glúten),burguer de frango ( base de ervilha - pode conter glúten) cebola caramelizada da casa feita com açúcar mascavo ,alface fresquinha , tomate, incrível queijo prato ( feito de castanhas)com fritas e bebida .Serve 1 pessoa", 63.90);
        double preco4 = calcularPrecoFinal(p4.getPreco(), desconto);
        p4.setPreco(preco4);
        produtoRepository.save(p4);
        
        Produto p5 = new Produto("Combos", "Combo Gangnam - Korean Style Chicken Burger + Fritas + Bebida", "Deliciosa receita Coreana: Pão de burger com gergelim ( opção sem glúten), alface fresca ,incrível burger de frango plant based chocante( base de ervilha - pode conter glúten) queijo prato de castanha de caju, tradicional maionese coreana de Goguchang ( opções médio picante ou muito picante) completando com a saborosa salada Coreana ( repolho roxo, repolho branco ,cebolinha e cenoura grelhados) Acompanha fritas e bebida (opçoẽs de troca dispiniveis)", 67.70);
        double preco5 = calcularPrecoFinal(p5.getPreco(), desconto);
        p5.setPreco(preco5);
        produtoRepository.save(p5);
        
        Produto p6 = new Produto("Combos", "Combo Hutteldorf-Schnitzel de Frango+Fritas+ Bebida", "Incrivel receita Austriaca ! Delicioso filé de frango plant based empanado( base de ervilha) Baguete,cole slaw da chef (maionese de repolho rouxo,verde e cenoura) e rucula- acompanha Bebida e Fritas com opçoẽs de troca Fica melhor ainda com Chrein(opcional) a raíz forte de beterraba tradicional do leste EuropeuServe 1 pessoa", 73.90);
        double preco6 = calcularPrecoFinal(p6.getPreco(), desconto);
        p6.setPreco(preco6);
        produtoRepository.save(p6);

        Produto p7 = new Produto("Sanduíches", "Sanduíche de linguiça, vinagrete e chimichuri", "Deliciosa tradicional receita Argentina : Pão francês fresquinho, 2 linguiças de 40 gramas plant based (base de ervilha - pode conter glúten) vinagrete temperado com limão , maionese de castanhas e chimichuri. Acompanha Bebida e fritas com opçoẽs de trocaServe 1 pessoa", 53.90);
        double preco7 = calcularPrecoFinal(p7.getPreco(), desconto);
        p7.setPreco(preco7);
        produtoRepository.save(p7);
        
        Produto p8 = new Produto("Sanduíches", "Hotdog com Chucrute e Mostarda Dijon", "Incrível receita Alemã ! Delicioso pão de hotdog , 2 chocante linguica de 40 grama(plant based base de ervilha - pode conter glúten) , delicioso chucrute temperado e mostarda Dijon. Acompanha fritas e bebida com opções de troca disponiveis", 56.90);
        double preco8 = calcularPrecoFinal(p8.getPreco(), desconto);
        p8.setPreco(preco8);
        produtoRepository.save(p8);

        // Pratos
        Produto p9 = new Produto("Pratos", "Penne al Pesto de nozes com frango grelhado ou linguiça", "Nosso pesto é simplismente incrível, feito com nozes, manjericão e creme de leite vegetal. Queijo parmesão ralado delicioso e sua opção de frango ou linguiça ( ambos de proteína de ervilha)Serve 1 pessoa (420g)", 37.90);
        double preco9 = calcularPrecoFinal(p9.getPreco(), desconto);
        p9.setPreco(preco9);
        produtoRepository.save(p9);

        // Itens sem combo
        produtoRepository.save(new Produto("Burgers", "Brooklyn (Meat Salad Burger)", "Nosso tradicional Brooklyn com delicioso pão de hambúrguer com gergelim (opção sem glúten ), incrivel burguer de carne plant based (100g e base de ervilha- pode conter gluten) e o chocante queijo de castanhas com cebola, picles, tomate fresquinho e um toque de ketchup e mostarda pra finalizar.", 0.0));
        produtoRepository.save(new Produto("Burgers", "Buckhead (Chicken Burger)", "Tradicional Buckhead - delicioso burger de frango Plant Based ( base de ervilha) , pão de hambúrguer com gergelim ( opção sem glúten),burguer de frango ( base de ervilha - pode conter glúten) cebola caramelizada da casa feita com açúcar mascavo ,alface fresquinha , tomate, incrível queijo prato ( feito de castanhas)", 0.0));
        produtoRepository.save(new Produto("Burgers", "Gangnam - Korean Style Chicken Burger", "Deliciosa receita Coreana: Pão de burger com gergelim ( opção sem glúten), alface fresca ,incrível burger de frango plant based chocante( base de ervilha - pode conter glúten) queijo prato de castanha de caju, tradicional maionese coreana de Goguchang ( opções médio picante ou muito picante) completando com a saborosa salada Coreana ( repolho roxo, repolho branco ,cebolinha e cenoura grelhados)", 0.0));
        produtoRepository.save(new Produto("Sanduíches", "Hutteldorf-Schnitzel de Frango", "Incrivel receita Austriaca ! Delicioso filé de frango plant based empanado( base de ervilha) Baguete,cole slaw da chef (maionese de repolho rouxo,verde e cenoura) e rucula- acompanha Bebida e Fritas com opçoẽs de troca Fica melhor ainda com Chrein(opcional) a raíz forte de beterraba tradicional do leste Europeu", 0.0));
    }
    
    private double calcularPrecoFinal(double precoOriginal, double desconto) {
        double precoComDesconto = precoOriginal * (1 - desconto);
        BigDecimal bd = new BigDecimal(precoComDesconto).setScale(2, RoundingMode.HALF_UP);
        double precoArredondado = bd.doubleValue();
        
        String precoFinalString = String.format("%.2f", precoArredondado);
        
        if (!precoFinalString.endsWith("0")) {
             return precoArredondado - 0.04;
        }

        return precoArredondado;
    }
}