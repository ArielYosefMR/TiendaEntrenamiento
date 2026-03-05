package com.sistema.tienda.backend.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.tienda.backend.dto.ItemVentaDTO;
import com.sistema.tienda.backend.dto.VentaDTO;
import com.sistema.tienda.backend.model.DetalleVenta;
import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.model.Producto;
import com.sistema.tienda.backend.model.Venta;
import com.sistema.tienda.backend.repository.DetalleVentaRepository;
import com.sistema.tienda.backend.repository.InventarioRepository;
import com.sistema.tienda.backend.repository.ProductoRepository;
import com.sistema.tienda.backend.repository.VentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaServiceI {

    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final ProductoRepository productoRepository;
    private final InventarioRepository inventarioRepository;

    @Override
    @Transactional
    public Venta registrarVenta(VentaDTO ventaDTO) {

        Venta venta = Venta.builder()
                .fecha(LocalDateTime.now())
                .total(BigDecimal.ZERO)
                .build();

        ventaRepository.save(venta);

        BigDecimal total = BigDecimal.ZERO;

        for (ItemVentaDTO item : ventaDTO.getItems()) {

            Producto producto = productoRepository.findById(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            Inventario inventario = inventarioRepository.findByProducto(producto)
                    .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

            if (inventario.getCantidad() < item.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            BigDecimal precioUnitario = producto.getPrecioVenta();

            BigDecimal subtotal = precioUnitario
                    .multiply(BigDecimal.valueOf(item.getCantidad()));

            DetalleVenta detalle = DetalleVenta.builder()
                    .venta(venta)
                    .producto(producto)
                    .cantidad(item.getCantidad())
                    .precioUnitario(precioUnitario)
                    .subtotal(subtotal)
                    .build();

            detalleVentaRepository.save(detalle);
            venta.getDetalles().add(detalle);

            inventario.setCantidad(
                    inventario.getCantidad() - item.getCantidad()
            );

            total = total.add(subtotal);
        }

        venta.setTotal(total);
        ventaRepository.save(venta);

        return venta;
    }
}