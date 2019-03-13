package de.baitando.japs.payment;

import de.baitando.japs.account.persistence.AccountStore;
import de.baitando.japs.account.persistence.internal.InMemoryAccountStore;
import de.baitando.japs.payment.persistence.PaymentStore;
import de.baitando.japs.payment.persistence.internal.InMemoryPaymentStore;
import de.baitando.japs.payment.service.PaymentService;
import de.baitando.japs.payment.service.internal.DefaultPaymentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PaymentServiceTest {

    @Test
    void transfer_withExistingIban_transfersMoney() {
        // Arrange
        AccountStore accountStore = new InMemoryAccountStore();
        PaymentStore paymentStore = new InMemoryPaymentStore();
        PaymentService paymentService = new DefaultPaymentService(accountStore, paymentStore);

        // Act
        paymentService.transfer("DE123456","DE654321", BigDecimal.valueOf(5.23));

        // Assert
        Assertions.assertThat(accountStore.getAccountByIban("DE123456").getBalance()).isEqualTo(BigDecimal.valueOf(1228.89));
        Assertions.assertThat(accountStore.getAccountByIban("DE654321").getBalance()).isEqualTo(BigDecimal.valueOf(4326.44));
    }
}
