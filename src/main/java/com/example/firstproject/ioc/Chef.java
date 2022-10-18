package com.example.firstproject.ioc;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Chef {

    //세프는 식재료 공장을 알고있음
    private IngredientFactory ingredientFactory;

    //세프가 식재료 공장과 협업하기 위한 DI  //
    //컴포넌트로 등록된 클래스에
    //생성자가 1개인 경우,
    //@Autowired가 자동으로 붙게 됩니다. 달려있는것이나 마찬가지입니다.


    public Chef(IngredientFactory ingredientFactory) {
        this.ingredientFactory=ingredientFactory;

    }

    public String cook(String menu) {
        // 재료 준비
        Ingredient ingredient = ingredientFactory.get(menu);


        //요리 반환
        return ingredient.getName()+ "으로 만든 " +menu;

    }
}
