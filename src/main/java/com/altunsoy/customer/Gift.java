package com.altunsoy.customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Data // getter setter toStringi veriyor
@AllArgsConstructor // sınıfntaki tüm değişkenlerle ontructor veriyor
@NoArgsConstructor
@Builder /// builder design pattern kullanarak bild ediliyor
public class Gift {



	private String name;
}

