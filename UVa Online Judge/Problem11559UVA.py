while True:
    try:
        num_participantes, presupuesto, num_hoteles, fines_semana = map(int, input().split())
        REF = 1 << 30; costo_minimo = REF 
    except:
        break

    for x in range(num_hoteles):
        costo_hotel = int(input())
        camas_disponibles = map(int,input().split())
        for num_camas in camas_disponibles:
            if num_camas >= num_participantes and num_participantes * costo_hotel <= presupuesto:
                costo_minimo = min(costo_minimo, num_participantes * costo_hotel)

    print(costo_minimo if costo_minimo != REF  else "stay home")
